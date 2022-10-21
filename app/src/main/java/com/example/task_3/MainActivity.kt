package com.example.task_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    private lateinit var result:TextView
    private var previousNumber:Float = 0F
    private var isFloat:Boolean = false
    private var clickOperationPermission = false
    private var canAddDot:Boolean = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        result = findViewById(R.id.textView3)
    }


    fun getNumber(view:View) {
        if (view is Button) {
            result.text = result.text.toString() + view.text.toString()
            clickOperationPermission = true
            canAddDot = true
        }
    }

    fun clear (view:View){

            result.text = ""
            previousNumber = 0F
            clickOperationPermission = false
    }

    fun operation(view: View){
        if (clickOperationPermission && view is Button) {

            getNumber(view)
            clickOperationPermission = false
            canAddDot = false

        }
        else {
            Toast.makeText(this,"Click Number!", Toast.LENGTH_SHORT).show()
        }

    }

    fun isDecimal(view:View){
        if (canAddDot && clickOperationPermission){
            result.text = result.text.toString() + "."
            canAddDot = false

        }
        else Toast.makeText(this,"Click Number!", Toast.LENGTH_SHORT).show()
    }

    fun getResult(view:View){

        if (!this.clickOperationPermission) {
            var res = result.text.toString()
            if ("+" in res && "-" in res && "*" in res && "/" in res ){

                if ("+" in res){
                    result.text = (res.toString().split("+").first().toFloat() + res.toString().split("+").last().toFloat()).toString()
                }





            }
            else {
                Toast.makeText(this,"Wrong Calculation!", Toast.LENGTH_SHORT).show()
            }







        }


    }






}