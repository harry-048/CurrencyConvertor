package com.example.currencyconvertor;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    final List<String> list = new ArrayList<String>();
    final List<String> values = new ArrayList<String>();
    ProgressBar progressBar;
    NumberFormat format = NumberFormat.getCurrencyInstance();
    Currency cr;
    double cval=1;

//    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
    EditText editCurrency;
    TextView txtCurrency;
    TextView txtSymbol;
    TextView txtSymbolTop;
    String convertCurrency = "";
    double currency = 1;
    double n =1;
    Spinner spTo;
    Spinner spFrom;

    ArrayAdapter<String> adpTo;
    // ArrayAdapter<String> adpFrom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        editCurrency = (EditText) findViewById(R.id.editText);
        txtCurrency = (TextView) findViewById(R.id.textView);
        txtSymbol = (TextView) findViewById(R.id.textView3);
        txtSymbolTop = (TextView) findViewById(R.id.textView4);
        spTo = (Spinner) findViewById(R.id.spinner);
        spFrom = (Spinner) findViewById(R.id.spinner2);

        adpTo = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        list.add("AED");
        list.add("AFN");
        list.add("ALL");
        list.add("AMD");
        list.add("ANG");
        list.add("AOA");
        list.add("ARS");
        list.add("AUD");
        list.add("AWG");
        list.add("AZN");
        list.add("BAM");
        list.add("BBD");
        list.add("BDT");
        list.add("BGN");
        list.add("BHD");
        list.add("BIF");
        list.add("BND");
        list.add("BOB");
        list.add("BRL");
        list.add("BSD");
        list.add("BTC");
        list.add("BTN");
        list.add("BWP");
        list.add("BYN");
        list.add("BYR");
        list.add("BZD");
        list.add("CAD");
        list.add("CDF");
        list.add("CHF");
        list.add("CLP");
        list.add("CNY");
        list.add("COP");
        list.add("CRC");
        list.add("CUP");
        list.add("CVE");
        list.add("CZK");
        list.add("DJF");
        list.add("DKK");
        list.add("DOP");
        list.add("DZD");
        list.add("EGP");
        list.add("ERN");
        list.add("ETB");
        list.add("EUR");
        list.add("FJD");
        list.add("FKP");
        list.add("GBP");
        list.add("GEL");
        list.add("GHS");
        list.add("GIP");
        list.add("GMD");
        list.add("GNF");
        list.add("GTQ");
        list.add("GYD");
        list.add("HKD");
        list.add("HNL");
        list.add("HRK");
        list.add("HTG");
        list.add("HUF");
        list.add("IDR");
        list.add("ILS");
        list.add("INR");
        list.add("IQD");
        list.add("IRR");
        list.add("ISK");
        list.add("JMD");
        list.add("JOD");
        list.add("JPY");
        list.add("KES");
        list.add("KGS");
        list.add("KHR");
        list.add("KMF");
        list.add("KPW");
        list.add("KRW");
        list.add("KWD");
        list.add("KYD");
        list.add("KZT");
        list.add("LAK");
        list.add("LBP");
        list.add("LKR");
        list.add("LRD");
        list.add("LSL");
        list.add("LVL");
        list.add("LYD");
        list.add("MAD");
        list.add("MDL");
        list.add("MGA");
        list.add("MKD");
        list.add("MMK");
        list.add("MNT");
        list.add("MOP");
        list.add("MRO");
        list.add("MUR");
        list.add("MVR");
        list.add("MWK");
        list.add("MXN");
        list.add("MYR");
        list.add("MZN");
        list.add("NAD");
        list.add("NGN");
        list.add("NIO");
        list.add("NOK");
        list.add("NPR");
        list.add("NZD");
        list.add("OMR");
        list.add("PAB");
        list.add("PEN");
        list.add("PGK");
        list.add("PHP");
        list.add("PKR");
        list.add("PLN");
        list.add("PYG");
        list.add("QAR");
        list.add("RON");
        list.add("RSD");
        list.add("RUB");
        list.add("RWF");
        list.add("SAR");
        list.add("SBD");
        list.add("SCR");
        list.add("SDG");
        list.add("SEK");
        list.add("SGD");
        list.add("SHP");
        list.add("SLL");
        list.add("SOS");
        list.add("SRD");
        list.add("STD");
        list.add("SYP");
        list.add("SZL");
        list.add("THB");
        list.add("TJS");
        list.add("TMT");
        list.add("TND");
        list.add("TOP");
        list.add("TRY");
        list.add("TTD");
        list.add("TWD");
        list.add("TZS");
        list.add("UAH");
        list.add("UGX");
        list.add("USD");
        list.add("UYU");
        list.add("UZS");
        list.add("VEF");
        list.add("VND");
        list.add("VUV");
        list.add("WST");
        list.add("XAF");
        list.add("XCD");
        list.add("XDR");
        list.add("XOF");
        list.add("XPF");
        list.add("YER");
        list.add("ZAR");
        list.add("ZMW");


        values.add("USDtoINR");
        values.add("INRtoUSD");
        values.add("USDtoUSD");
        values.add("INRtoINR");





        adpTo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTo.setAdapter(adpTo);

        //  adpFrom.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFrom.setAdapter(adpTo);

        spFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editCurrency.setText("" + cval+spFrom.getSelectedItem().toString());
                //  convertCurrency=list.get(position);
                // convertCurrency=convertCurrency+"to";
                //    Toast.makeText(getBaseContext(), "first", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //   convertCurrency=list.get(0)+"to";
                spFrom.setSelection(0);
                //  Toast.makeText(getBaseContext(), "firstnotselect", Toast.LENGTH_SHORT).show();
            }
        });

        spTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // convertCurrency=convertCurrency+list.get(position);
                //   Toast.makeText(getBaseContext(), "second", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //  convertCurrency=convertCurrency+list.get(0);
                spTo.setSelection(1);
                //   Toast.makeText(getBaseContext(), "secondnotselect", Toast.LENGTH_SHORT).show();
            }
        });


         editCurrency.setText("" + 1+spFrom.getSelectedItem().toString());
        Log.d("edittext val", "" + editCurrency.getText());
        Toast.makeText(getBaseContext(),editCurrency.getText(),Toast.LENGTH_SHORT).show();

      //  editCurrency.setOnContextClickListener(ON);

    }

    public void covertion(View view) {


      //  currency = Double.parseDouble(editCurrency.getText().toString());
      //  n=currency;
      //  editCurrency.setText(editCurrency.getText().toString()+"  "+spFrom.getSelectedItem().toString());
        if (convertCurrency == null || convertCurrency == "" || convertCurrency == "USDto" || convertCurrency == "INRto" || convertCurrency == "USD" || convertCurrency == "INR") {

            // spFrom.setSelection(0);
            // spTo.setSelection(1);

        }
        convertCurrency = spFrom.getSelectedItem().toString() + "_" + spTo.getSelectedItem().toString();
        // Toast.makeText(getBaseContext(), "cc="+convertCurrency, Toast.LENGTH_SHORT).show();
        Log.d("cc", "" + convertCurrency);
        Log.d("val", values.get(0));
        Log.d("cur", currency + "");
       /* if (convertCurrency.equals(values.get(0))) {
            currency = currency * 69.996904;
            Log.d("firr", currency + "");
        } else if (convertCurrency.equals(values.get(1))) {
            currency = currency * 0.014;
        }
        Log.d("currr", currency + "");
        txtCurrency.setText("" + currency);
        currency = 1;*/


        GetCurrencyVal task = new GetCurrencyVal();
        task.execute();


    }



    public class GetCurrencyVal extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            txtCurrency.setText("");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try{
                progressBar.setVisibility(View.GONE);
                String currencyStr = s.split(":")[1].replace("}", "");
                String str = editCurrency.getText().toString();
                str = str.substring(0, str.length()-3);


                currency = Double.parseDouble(str);
                cval=currency;
                Toast.makeText(getBaseContext(),currency+"",Toast.LENGTH_SHORT).show();
                Log.d("firstcur", currency + "");
                currency = currency * (Double.parseDouble(currencyStr));

                Log.d("currency val", "" + format.format(currency));

               // txtSymbolTop.setText(spFrom.getSelectedItem().toString());
               // txtSymbol.setText(spTo.getSelectedItem().toString());

                currencyStr = NumberFormat.getInstance().format(currency);
                txtCurrency.setText(currencyStr+spTo.getSelectedItem().toString());
                editCurrency.setText("" + cval+spFrom.getSelectedItem().toString());

               // .getCurrencyInstance().format(currency)
            //    Toast.makeText(getBaseContext(),NumberFormat.getInstance().format(currency),Toast.LENGTH_SHORT).show();
              //  NumberFormat.getNumberInstance(Locale.getDefault()).format(currency);
             //   Toast.makeText(getBaseContext(),String.format("%,d","a"+currency),Toast.LENGTH_SHORT).show();
                convertCurrency = "";
                currencyStr="";
            }
            catch (Exception e){
             //   AlertDialog.Builder builder1  = new AlertDialog.Builder(this);
//                builder1.setMessage("No Internet Connection..");
//                builder1.setCancelable(true);
//                builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                    }
//                });
                Toast.makeText(getBaseContext(), "No Internet Connection..", Toast.LENGTH_SHORT).show();

            }

        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(String... strings) {
            String str = "https://free.currencyconverterapi.com/api/v6/convert?q=" + convertCurrency + "&compact=ultra&apiKey=b2ff44cc102332c48125";
            try {
                URL url = new URL(str);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();


                BufferedReader in = new BufferedReader(new InputStreamReader(
                        urlConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
/*
                InputStream input = new BufferedInputStream(url.openStream(),8192);

                byte data[] = new byte[1024];

               input.read(data);*/
                String output = response.toString();
                Log.d("asdasdas", "Output Code" + output);
                Log.d("url", convertCurrency + "");
                return output;

                //OutputStream output = new FileOutputStream();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            publishProgress();
            return null;
        }
    }

}

