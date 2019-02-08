package com.example.redes.servicioweb;

import android.app.Activity;

public class register_user extends Activity {
    EditText userName,passwprd;
    Button resister,login;
    ProgressBar progressBar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resister_user);
        userName=(EditText) findViewById(R.id.editText1);;
        passwprd=(EditText) findViewById(R.id.editText2);
        resister=(Button) findViewById(R.id.button1);

        progressBar=(ProgressBar) findViewById(R.id.progressBar1);
        progressBar.setVisibility(View.GONE);

        resister.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);

                String s1=userName.getText().toString();
                String s2=passwprd.getText().toString();
                new ExecuteTask().execute(s1,s2);
            }
        });




    }

    class ExecuteTask extends AsyncTask<String, Integer, String>
    {

        @Override
        protected String doInBackground(String... params) {

            PostData(params);
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            progressBar.setVisibility(View.GONE);
        }

    }



    public void PostData(String[] valuse) {
        try
        {
            HttpClient httpClient=new DefaultHttpClient();
            HttpPost httpPost=new HttpPost(
                    "http://10.0.0.8:7777/HttpPostServlet/servlet/httpPostServlet");
            List<NameValuePair> list=new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("name", valuse[0]));
            list.add(new BasicNameValuePair("pass",valuse[1]));
            httpPost.setEntity(new UrlEncodedFormEntity(list));
            httpClient.execute(httpPost);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
}
