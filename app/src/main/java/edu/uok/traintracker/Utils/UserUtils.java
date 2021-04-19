package edu.uok.traintracker.Utils;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

import edu.uok.traintracker.Common;

public class UserUtils {
    public static void updateUser(View v, Map<String, Object> updateData) {
        FirebaseDatabase.getInstance()
                .getReference(Common.DRIVER_INFO_REFERENCE)
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .updateChildren(updateData)
                .addOnFailureListener(e -> Snackbar.make(v, e.getMessage(), Snackbar.LENGTH_SHORT).show()).addOnSuccessListener(aVoid -> Snackbar.make(v, "Update information successfully!", Snackbar.LENGTH_SHORT).show());

    }
}
