package com.example.viikko10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    WebView webview;
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        webview = findViewById(R.id.webView);
        button = findViewById(R.id.button);

        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("https://www.aaltorejects.fi");
    }

    public void onClick(View v) {
        String input = editText.getText().toString();
        searchFunction(input);
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);

    }

    public void searchFunction(String input){
        String address;
        if (input.startsWith("http://")){
            address = input;
        } else {
            address = "http://"+input;
        }
        webview.loadUrl(address);
    }
}