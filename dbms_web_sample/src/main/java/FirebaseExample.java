
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;

import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseExample {

    public static void main(String[] args) throws IOException {
        // Path to your service account key JSON file
        String pathToServiceAccountKey = "\"C:\\Users\\Chien Starry\\Downloads\\db-github-11ca8-firebase-adminsdk-1i1f8-0df4f323da.json\"";

        // Initialize FirebaseApp with service account key file
        FileInputStream serviceAccount = new FileInputStream(pathToServiceAccountKey);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        FirebaseApp.initializeApp(options);

        // Get a reference to the database
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        // Write data to the database
        ref.child("users").child("userId").setValueAsync("John Doe");

        // Read data from the database
        ref.child("users").child("userId").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue(String.class);
                System.out.println("Name: " + name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }
}
