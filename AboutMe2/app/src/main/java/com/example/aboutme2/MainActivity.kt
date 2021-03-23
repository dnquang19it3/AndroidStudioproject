package com.example.aboutme2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val doneBtn = findViewById<Button>(R.id.done_btn)
        val nicknameText = findViewById<TextView>(R.id.nickname_text)

        doneBtn.setOnClickListener { addNickname(it) }
        nicknameText.setOnClickListener{updateNickName(it)}

    }

    private fun addNickname(view: View) {
        //  Get nick name Edit & nick name Text
       val nicknameEdit = findViewById<EditText>(R.id.nickname_edit)
        val nicknameText= findViewById<TextView>(R.id.nickname_text);
        //  Assign
        nicknameText.text = nicknameEdit.text

        //  Visibility: gone & visible
        nicknameEdit.visibility = View.GONE
        view.visibility = View.GONE
        nicknameText.visibility = View.VISIBLE

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

    }
    private fun updateNickName(view: View) {
        val nicknameEdit = findViewById<EditText>(R.id.nickname_edit)
        val doneBtn = findViewById<Button>(R.id.done_btn)

        nicknameEdit.visibility = View.VISIBLE
        doneBtn.visibility = View.VISIBLE
        view.visibility = View.GONE

        // Set the focus to the edit text.
        nicknameEdit.requestFocus()
        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(nicknameEdit, 0)
    }
}