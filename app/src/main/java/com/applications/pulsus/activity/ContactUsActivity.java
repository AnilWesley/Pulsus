package com.applications.pulsus.activity;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.applications.pulsus.R;
import com.applications.pulsus.api.ApiInterface;
import com.applications.pulsus.api.RetrofitClient;
import com.applications.pulsus.models.BaseResponse;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactUsActivity extends AppCompatActivity {

    @BindView(R.id.editFirst)
    TextInputEditText editFirst;
    @BindView(R.id.editEmail)
    TextInputEditText editEmail;
    @BindView(R.id.editPhone)
    TextInputEditText editPhone;
    @BindView(R.id.editQuires)
    TextInputEditText editQuires;
    @BindView(R.id.btnDownload)
    Button btnDownload;
    @BindView(R.id.txtmailAmerica)
    TextView txtmailAmerica;
    @BindView(R.id.progressBar)
    LinearLayout progressBar;

    String firstName, email, phone, quires;
    String TAG = "RESPONSE_DATA";
    String date;
    @BindView(R.id.txtmail2)
    TextView txtmail2;
    @BindView(R.id.txtmail3)
    TextView txtmail3;
    @BindView(R.id.txtmail4)
    TextView txtmail4;
    @BindView(R.id.txtDailUK)
    TextView txtDailUK;
    @BindView(R.id.txtDailUSA)
    TextView txtDailUSA;
    @BindView(R.id.txtMail)
    TextView txtMail;
    @BindView(R.id.txtdail)
    TextView txtdail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        ButterKnife.bind(this);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Contact Us");

        Date c = Calendar.getInstance().getTime();

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        date = df.format(c);


    }


    @OnClick({R.id.txtmailAmerica, R.id.txtmail2, R.id.txtmail3, R.id.txtmail4, R.id.txtDailUK, R.id.txtDailUSA, R.id.btnDownload, R.id.txtMail, R.id.txtdail})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txtmailAmerica:
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{txtmailAmerica.getText().toString()});

                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (ActivityNotFoundException ex) {
                    Toast.makeText(ContactUsActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.txtmail2:
                Intent i2 = new Intent(Intent.ACTION_SEND);
                i2.setType("message/rfc822");
                i2.putExtra(Intent.EXTRA_EMAIL, new String[]{txtmail2.getText().toString()});

                try {
                    startActivity(Intent.createChooser(i2, "Send mail..."));
                } catch (ActivityNotFoundException ex) {
                    Toast.makeText(ContactUsActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.txtmail3:
                Intent i3 = new Intent(Intent.ACTION_SEND);
                i3.setType("message/rfc822");
                i3.putExtra(Intent.EXTRA_EMAIL, new String[]{txtmail3.getText().toString()});

                try {
                    startActivity(Intent.createChooser(i3, "Send mail..."));
                } catch (ActivityNotFoundException ex) {
                    Toast.makeText(ContactUsActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.txtmail4:
                Intent i4= new Intent(Intent.ACTION_SEND);
                i4.setType("message/rfc822");
                i4.putExtra(Intent.EXTRA_EMAIL, new String[]{txtmail4.getText().toString()});

                try {
                    startActivity(Intent.createChooser(i4, "Send mail..."));
                } catch (ActivityNotFoundException ex) {
                    Toast.makeText(ContactUsActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.txtDailUK:
                Intent intent1 = new Intent(Intent.ACTION_DIAL);
                String temp1 = "tel:" + txtDailUK.getText().toString();
                intent1.setData(Uri.parse(temp1));
                startActivity(intent1);
                break;
            case R.id.txtDailUSA:
                Intent intent2 = new Intent(Intent.ACTION_DIAL);
                String temp2 = "tel:" + txtDailUSA.getText().toString();
                intent2.setData(Uri.parse(temp2));
                startActivity(intent2);
                break;
            case R.id.txtMail:
                Intent i5 = new Intent(Intent.ACTION_SEND);
                i5.setType("message/rfc822");
                i5.putExtra(Intent.EXTRA_EMAIL, new String[]{txtMail.getText().toString()});

                try {
                    startActivity(Intent.createChooser(i5, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ContactUsActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.txtdail:
                Intent intent4 = new Intent(Intent.ACTION_DIAL);
                String temp5 = "tel:" + txtdail.getText().toString();
                intent4.setData(Uri.parse(temp5));
                startActivity(intent4);
                break;
            case R.id.btnDownload:
                firstName = Objects.requireNonNull(editFirst.getText()).toString().trim();
                email = Objects.requireNonNull(editEmail.getText()).toString().trim();
                phone = Objects.requireNonNull(editPhone.getText()).toString().trim();
                quires = Objects.requireNonNull(editQuires.getText()).toString().trim();

                if (firstName.isEmpty()) {
                    Toast.makeText(ContactUsActivity.this, "Enter Name", Toast.LENGTH_SHORT).show();


                } else if (email.isEmpty()) {
                    Toast.makeText(ContactUsActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();

                } else if (phone.isEmpty()) {
                    Toast.makeText(ContactUsActivity.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();

                } else if (quires.isEmpty()) {
                    Toast.makeText(ContactUsActivity.this, "Enter Researh Interest", Toast.LENGTH_SHORT).show();

                } else {
                    downloadBrochure();

                }

                break;
        }
    }

    public void downloadBrochure() {

        progressBar.setVisibility(View.VISIBLE);
        ApiInterface apiInterface = RetrofitClient.getClient(this).create(ApiInterface.class);
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("name", firstName);
        jsonObject.addProperty("email", email);
        jsonObject.addProperty("contact", phone);
        jsonObject.addProperty("research", quires);
        jsonObject.addProperty("created_at", date);
        jsonObject.addProperty("source", "android");
        Log.d(TAG, "" + jsonObject);
        apiInterface.processDataInsertSubscription(jsonObject).enqueue(new Callback<BaseResponse>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NotNull Call<BaseResponse> call, @NotNull Response<BaseResponse> response) {


                if (response.isSuccessful()) {
                    BaseResponse brochureDownload = response.body();
                    assert brochureDownload != null;
                    if (brochureDownload.isStatus()) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(ContactUsActivity.this, "Submitted Successfully", Toast.LENGTH_SHORT).show();
                        editFirst.setText("");
                        editEmail.setText("");
                        editPhone.setText("");
                        editQuires.setText("");
                    } else {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(ContactUsActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(ContactUsActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(@NotNull Call<BaseResponse> call, @NotNull Throwable t) {
                //progressBar1.setVisibility(View.GONE);

            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


}