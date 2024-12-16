package gonzaleztorralbo.arturo.pmdm02;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.navigation.NavController;


import com.google.android.material.snackbar.Snackbar;

import gonzaleztorralbo.arturo.pmdm02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //Nav controller config
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController);

        //Snackbar
        Snackbar.make(binding.getRoot(), "Bienvenidos al mundo de Mario", Snackbar.LENGTH_LONG).show();

    }

    //------------------------------
    public void heroClicked(HeroData hero, View view) {
        // Crear un Bundle para pasar los datos al HeroDetailFragment
        Bundle bundle = new Bundle();
        bundle.putString("imagen", hero.getImagen()); // Pasa la imagen del juego
        bundle.putString("nombre", hero.getNombre());
        bundle.putString("descripcion", hero.getDescripcion());
        bundle.putString("habilidades", hero.getHabilidades());

        // Navegar al HeroDetailFragment con el Bundle
        Navigation.findNavController(view).navigate(R.id.heroDetailFragment, bundle);
    }

    @Override
    public boolean onSupportNavigateUp() {
        // Utiliza el método navigateUp del NavController
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
    // Inflar el menú en la AppBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.drawer_menu, menu);
        return true;
    }
    // Manejar la selección del ítem del menú
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.acercade) {
            showAboutDialog(); // Mostrar el diálogo "Acerca de..."
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void showAboutDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Acerca de")
                .setMessage("Aplicación desarrollada por Arturo Gonzalez.\nVersión 1.0.")

                .setPositiveButton("Aceptar", (dialog, which) -> dialog.dismiss())
                .show();
    }


}

