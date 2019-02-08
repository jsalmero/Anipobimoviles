package com.example.redes.webservice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    EditText etGitHubUser; // This will be a reference to our GitHub username input.
    Button btnGetRepos;  // This is a reference to the "Get Repos" button.
    TextView tvRepoList;  // This will reference our repo list text box.
    RequestQueue requestQueue;  // This is our requests queue to process our HTTP requests.

    String baseUrl = "https://api.github.com/users/";  // This is the API base URL (GitHub API)
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.etGitHubUser = (EditText) findViewById(R.id.et_github_user);  // Link our github user text box.
        this.btnGetRepos = (Button) findViewById(R.id.btn_get_repos);  // Link our clicky button.
        this.tvRepoList = (TextView) findViewById(R.id.tv_repo_list);  // Link our repository list text output box.
        this.tvRepoList.setMovementMethod(new ScrollingMovementMethod());  // This makes our text box scrollable, for those big GitHub contributors with lots of repos :)

        requestQueue = Volley.newRequestQueue(this); //
    }
}
