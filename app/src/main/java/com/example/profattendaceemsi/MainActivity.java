package com.example.profattendaceemsi;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    //private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*db = FirebaseFirestore.getInstance();

        createProfesseursCollection();
        createGroupesCollection();
        createEtudiantsCollection();
        createAbsencesCollection();
        createEmploisDuTempsCollection();
        createDocumentsCollection();
        createRattrapagesCollection();
    }

        private void createProfesseursCollection() {
            Map<String, Object> professeur = new HashMap<>();
            professeur.put("nom", "Youssef");
            professeur.put("prenom", "Ouriniche");
            professeur.put("email", "youssef.ou@example.com");
            professeur.put("photo", "url_to_photo");

            db.collection("professeurs")
                    .add(professeur)
                    .addOnSuccessListener(documentReference -> Log.d("MainActivity", "Professeur added with ID: " + documentReference.getId()))
                    .addOnFailureListener(e -> Log.w("MainActivity", "Error adding professeur", e));
        }

        private void createGroupesCollection() {
            Map<String, Object> groupe = new HashMap<>();
            groupe.put("site", "Campus A");
            groupe.put("matiere", "Mathematics");

            db.collection("groupes")
                    .add(groupe)
                    .addOnSuccessListener(documentReference -> Log.d("MainActivity", "Groupe added with ID: " + documentReference.getId()))
                    .addOnFailureListener(e -> Log.w("MainActivity", "Error adding groupe", e));
        }

        private void createEtudiantsCollection() {
            Map<String, Object> etudiant = new HashMap<>();
            etudiant.put("nom", "Yassine");
            etudiant.put("prenom", "MAjahd");
            etudiant.put("groupe", "Groupe 1");

            db.collection("etudiants")
                    .add(etudiant)
                    .addOnSuccessListener(documentReference -> Log.d("MainActivity", "Etudiant added with ID: " + documentReference.getId()))
                    .addOnFailureListener(e -> Log.w("MainActivity", "Error adding etudiant", e));
        }

        private void createAbsencesCollection() {
            Map<String, Object> absence = new HashMap<>();
            absence.put("etudiant", "Ahmed ");
            absence.put("timestamp", System.currentTimeMillis());

            db.collection("absences")
                    .add(absence)
                    .addOnSuccessListener(documentReference -> Log.d("MainActivity", "Absence added with ID: " + documentReference.getId()))
                    .addOnFailureListener(e -> Log.w("MainActivity", "Error adding absence", e));
        }

        private void createEmploisDuTempsCollection() {
            Map<String, Object> emploiDuTemps = new HashMap<>();
            emploiDuTemps.put("professeur", "Mohamed ahmad");
            emploiDuTemps.put("horaire", "Lundi 9h-11h");

            db.collection("emplois_du_temps")
                    .add(emploiDuTemps)
                    .addOnSuccessListener(documentReference -> Log.d("MainActivity", "Emploi du temps added with ID: " + documentReference.getId()))
                    .addOnFailureListener(e -> Log.w("MainActivity", "Error adding emploi du temps", e));
        }

        private void createDocumentsCollection() {
            Map<String, Object> document = new HashMap<>();
            document.put("professeur", "Jean Dupont");
            document.put("fichier", "url_to_file");

            db.collection("documents")
                    .add(document)
                    .addOnSuccessListener(documentReference -> Log.d("MainActivity", "Document added with ID: " + documentReference.getId()))
                    .addOnFailureListener(e -> Log.w("MainActivity", "Error adding document", e));
        }

        private void createRattrapagesCollection() {
            Map<String, Object> rattrapage = new HashMap<>();
            rattrapage.put("professeur", "Jean Dupont");
            rattrapage.put("horaire", "Vendredi 14h-16h");

            db.collection("rattrapages")
                    .add(rattrapage)
                    .addOnSuccessListener(documentReference -> Log.d("MainActivity", "Rattrapage added with ID: " + documentReference.getId()))
                    .addOnFailureListener(e -> Log.w("MainActivity", "Error adding rattrapage", e));
        }*/

    }
}