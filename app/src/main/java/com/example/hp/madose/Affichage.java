package com.example.hp.madose;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import java.util.List;

public class Affichage extends AppCompatActivity {
    private BaseDeDonne bd;
    private TextView categorie;
    private TextView fournisseur;
    private TextView departement;
    private TextView employe;
    private TextView stock;
    private TextView stock1;
    private TextView stocke;
    private TextView cout,demande;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);
        bd = new BaseDeDonne(this);



        // bd.insertCat("mobilier");

/*
        textView=(TextView)findViewById(R.id.textView4);
        List<AddEC>affE=bd.afficheEntre();
        for(AddEC emp:affE)
        {
            textView.append(emp.toString()+"\n\n");
        }
*/




/*
        textView=(TextView)findViewById(R.id.textView4);
        affichage=(TextView)findViewById(R.id.textView2);
        ArrayList<String> nc=bd.selectCat("mobilier");


        for(String emp:nc)
        {
            textView.append(emp.toString());
        }
**/
//debut ooooooooooooooooooiiiiiiiiiiiiiiiiiiiiiiiiiooooooooooooooooooooooooooooooooo

       if (getIntent().getStringExtra("passage").equals("fournisseur"))
        {
            fournisseur = (TextView) findViewById(R.id.textView4);

            List<FournisseurC> affF = bd.afficheF();
            for (FournisseurC emp : affF) {
                fournisseur.append(emp.toString() + "\n\n");
            }

        }

        else if (getIntent().getStringExtra("passage").equals("departement"))
        {
            departement = (TextView) findViewById(R.id.textView4);

            List<DepartementC> affF = bd.afficheDepart();
            for (DepartementC emp : affF) {
                departement.append(emp.toString() + "\n\n");
            }

        }

        if (getIntent().getStringExtra("passage").equals("employe"))
        {
            employe = (TextView) findViewById(R.id.textView4);

            List<EmployeC> affF = bd.afficheE();
            for (EmployeC emp : affF) {
                employe.append(emp.toString() + "\n\n");
            }

        }
//fin iiiiiiiiiiiiiiiiiiiiiiiiiiiiioooooooooooooooooooooooooooooooooooooiiiiiiiiiiiiiiiiiiiiiiiiiii



      /*  affichage=(TextView)findViewById(R.id.textView2);

        List<AddBEC>affEb=bd.afficheBesoinEntre();
        for(AddBEC emp:affEb)
        {
            affichage.append(emp.toString()+"\n\n");
        }*/



        if (getIntent().getStringExtra("passage").equals("categorie"))

        {
            categorie = (TextView) findViewById(R.id.textView2);

            List<CategorieC> affC = bd.afficheCat();
            for (CategorieC emp : affC) {
                categorie.append(emp.toString() + "\n\n");
            }
        }

        if (getIntent().getStringExtra("passage").equals("besoin")) {
             employe = (TextView) findViewById(R.id.textView4);
/*


        }*/
             List<BesoinC> affC = bd.afficheB();
             for (BesoinC emp : affC) {
                 employe.append(emp.toString() + "\n\n");
             }
         }

        if (getIntent().getStringExtra("passage").equals("stock")) {
        stock = (TextView) findViewById(R.id.textView2);
        stock.setText("LISTE DES BESOINS (MATERIELS) ET LEUR STOCK \n");
        List<StockC> affS = bd.afficheSt();
        List<StockC> affS1=bd.afficheSt1();
        for (StockC emp : affS) {
            if (emp.getTypeBes().equals("non amortissable")) {
                stock.append(emp.toString() + "\n\n");
            }

        }
            for (StockC emp : affS1) {
                if (emp.getTypeBes().equals("amortissable")) {
                    stock.append(emp.toString1() + "\n\n");
                }

            }
        }

        if (getIntent().getStringExtra("passage").equals("sortie")) {
            stock1 = (TextView) findViewById(R.id.textView2);
            stock1.setText("LISTE DES BESOINS (MATERIELS) LIVRES AUX EMPLOYES \n\n\n");
        List<Stock2> affF = bd.afficheStock2();
        for (Stock2 emp : affF) {
            stock1.append(emp.toString() + "\n\n");
           }
        }

        if (getIntent().getStringExtra("passage").equals("entree")) {
            stocke = (TextView) findViewById(R.id.textView2);
            stocke.setText("LISTE DES BESOINS (MATERIELS) ENTRES \n\n\n");
            List<Stock1> affF = bd.afficheStock1();
            for (Stock1 emp : affF) {
                stocke.append(emp.toString() + "\n\n");
            }
        }
        if (getIntent().getStringExtra("passage").equals("Cout")){
            cout = (TextView) findViewById(R.id.textView2);
            cout.setText("LISTE DES BESOINS (MATERIELS) ENTRES \n\n\n");



            List<CoutC> affF = bd.CoutBesoin(MyApplication.getGlobalVarValue());
       //     Toast.makeText(getBaseContext(),getIntent().getStringExtra("passage"),Toast.LENGTH_LONG);
           for (CoutC emp : affF) {
               cout.append(emp.toString() + "\n\n");
           }
            AlertDialog.Builder builder = new AlertDialog.Builder(Affichage.this);
            builder.setMessage("Le coût total en approvisionnement du besoin "+MyApplication.getGlobalVarValue()+" est "+MyApplication.getCoutTotBes()+" FCFA.");
            builder.setTitle(R.string.dialog_title);
            builder.setPositiveButton("Voir plus", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {


                }
            });
            builder.create();
            builder.show();
        }

        if (getIntent().getStringExtra("passage").equals("demande")) {
            demande = (TextView) findViewById(R.id.textView2);
            demande.setText("LISTE DES DEMANDES DE BESOINS PAR PERSONNE \n\n\n");
            List<DemandeC> affF = bd.afficheDemande();
            for (DemandeC emp : affF) {
                demande.append(emp.toString() + "\n\n");
            }
        }

        if (getIntent().getStringExtra("passage").equals("Rupture")){
            cout = (TextView) findViewById(R.id.textView2);
            cout.setText("LISTE DES BESOINS (MATERIELS) EN RUPTURE \n\n\n");

            boolean a=true;



            List<RuptureC> affF = bd.RupureCheck();
            //     Toast.makeText(getBaseContext(),getIntent().getStringExtra("passage"),Toast.LENGTH_LONG);
            for (RuptureC emp : affF) {
                cout.append(emp.toString() + "\n\n");
            }
            if (MyApplication.isDone()){
                AlertDialog.Builder builder = new AlertDialog.Builder(Affichage.this);
                builder.setMessage("Certains de vos articles sont en rupture");
                builder.setTitle("Rupture");
                builder.setPositiveButton("Voir", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                builder.create();
                builder.show();


            }
            else{
                AlertDialog.Builder builder = new AlertDialog.Builder(Affichage.this);
                builder.setMessage("Aucun de vos articles n'est en rupture");
                builder.setTitle("Rupture Check");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent=new Intent(Affichage.this,Acceuil.class);
                        startActivity(intent);

                    }
                });
                builder.create();
                builder.show();
            }




        }

        if (getIntent().getStringExtra("passage").equals("Rupture_original")) {
            cout = (TextView) findViewById(R.id.textView2);
            cout.setText("LISTE DES BESOINS (MATERIELS) EN RUPTURE \n\n\n");




            List<RuptureC> affF = bd.RupureCheck();
            //     Toast.makeText(getBaseContext(),getIntent().getStringExtra("passage"),Toast.LENGTH_LONG);
            for (RuptureC emp : affF) {
                cout.append(emp.toString() + "\n\n");
            }

        }

        findViewById(R.id.floatingActionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Affichage.this,Acceuil.class);
                startActivity(intent);
            }
        });

    }
}
