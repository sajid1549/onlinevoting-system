package com.onlie.voting.onlinevotingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SelectParty extends AppCompatActivity {

    Button party1,party2,party3;
    private DatabaseReference mref;
    private ProgressDialog LoadingBar;
    String Phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_party);

        party1=(Button)findViewById(R.id.party1);
        party1.setText("BJP");
        party2=(Button)findViewById(R.id.party2);
        party2.setText("CONG");
        party3=(Button)findViewById(R.id.party3);
        party3.setText("AAP");
        Intent i=getIntent();
        Phone=i.getStringExtra("phone");
        mref= FirebaseDatabase.getInstance().getReference();
        LoadingBar=new ProgressDialog(this);


        party1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final AlertDialog.Builder builder=new AlertDialog.Builder(SelectParty.this);
                builder.setTitle("Confirm Your Party");
                builder.setMessage("Do you want to give your vote to BJP");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        LoadingBar.setTitle("Voting Inprogress");
                        LoadingBar.setMessage("Please wait..");
                        LoadingBar.setCanceledOnTouchOutside(false);
                        LoadingBar.show();

                        mref.child("Users").child(Phone).child("Party").setValue("party1").addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                mref.child("Users").child(Phone).child("Vote").setValue("1");
                                Intent i=new Intent(SelectParty.this,FinalActivity.class);
                                i.putExtra("phone",Phone);
                                i.putExtra("partyname","party1");

                                startActivity(i);

                                LoadingBar.dismiss();
                                Toast.makeText(SelectParty.this, "Your Vote is Submitted to our database..", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                builder.show();




            }
        });
        party2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(SelectParty.this);
                builder.setTitle("Confirm Your Party");
                builder.setMessage("Do you want to give your vote to CONG");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        LoadingBar.setTitle("Voting Inprogress");
                        LoadingBar.setMessage("Please wait..");
                        LoadingBar.setCanceledOnTouchOutside(false);
                        LoadingBar.show();

                        mref.child("Users").child(Phone).child("Party").setValue("party2").addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                mref.child("Users").child(Phone).child("Vote").setValue("1");


                                Intent i=new Intent(SelectParty.this,FinalActivity.class);
                                i.putExtra("phone",Phone);
                                i.putExtra("partyname","CONG");

                                startActivity(i);

                                LoadingBar.dismiss();
                                Toast.makeText(SelectParty.this, "Your Vote is Submitted to our database..", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });
        party3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(SelectParty.this);
                builder.setTitle("Confirm Your Party");
                builder.setMessage("Do you want to give your vote to AAP");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        LoadingBar.setTitle("Voting Inprogress");
                        LoadingBar.setMessage("Please wait..");
                        LoadingBar.setCanceledOnTouchOutside(false);
                        LoadingBar.show();

                        mref.child("Users").child(Phone).child("Party").setValue("party1").addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                mref.child("Users").child(Phone).child("Vote").setValue("1");


                                Intent i=new Intent(SelectParty.this,FinalActivity.class);
                                i.putExtra("phone",Phone);
                                i.putExtra("partyname","AAP");

                                startActivity(i);

                                LoadingBar.dismiss();
                                Toast.makeText(SelectParty.this, "Your Vote is Submitted to our database..", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
