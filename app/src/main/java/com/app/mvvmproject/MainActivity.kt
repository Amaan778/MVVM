package com.app.mvvmproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var write:EditText
    private lateinit var btn:Button
    private lateinit var texts:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        write=findViewById(R.id.txt)
        btn=findViewById(R.id.btn)
        texts=findViewById(R.id.output)

        val notesDao=NotesDatabase.getDatabase(applicationContext).notesDao()
        val notesrepository=NotesRepository(notesDao)
        val mainview=ViewModelProvider(this,MinviewmodelFactory(notesrepository)).get(MainViewModel::class.java)

        mainview.getNotes().observe(this,{
            texts.text=it.toString()
        })

        btn.setOnClickListener(View.OnClickListener {
            Toast.makeText(this,"clicking",Toast.LENGTH_SHORT).show()
            if (write.text.isEmpty()){
                Toast.makeText(this,"please write something",Toast.LENGTH_SHORT).show()
            }else{

                mainview.insertnotes(Notes(0,write.text.toString()))
                Toast.makeText(this,"Done",Toast.LENGTH_SHORT).show()
                write.text=null

            }
        })


    }
}