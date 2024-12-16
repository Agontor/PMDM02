package gonzaleztorralbo.arturo.pmdm02;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gonzaleztorralbo.arturo.pmdm02.databinding.HeroListFragmentBinding;

import java.util.ArrayList;

public class HeroListFragment extends Fragment {

    private HeroListFragmentBinding binding; // Binding para el layout
    private ArrayList<HeroData> heroes; // Lista de juegos
    private HeroRecyclerViewAdapter adapter; // Adaptador del RecyclerView

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar el layout utilizando el binding
        binding = HeroListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa la lista de juegos
        loadHeroes(); // Cargar los juegos (puedes implementar esta función para obtener datos)

        // Configurar el RecyclerView
        adapter = new HeroRecyclerViewAdapter(heroes, getActivity());
        binding.heroesRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.heroesRecyclerview.setAdapter(adapter);


    }

    // Método para cargar juegos (puedes implementar tu lógica aquí)
    private void loadHeroes() {
        heroes = new ArrayList<HeroData>();
        // Llenar la lista con datos de videojuegos
        heroes.add(new HeroData(
                "drawable/mario90s.png",
                "Mario",
                "Heroe del Reino champiñon y hermano de Luigi",
                "Correr, Saltar, Lanzar Bola de fuego, Romper bloques."
        ));

        heroes.add(new HeroData(
                "drawable/luigi90s.png",
                "Luigi",
                "Heroe del Reino champiñon y hermano de Mario",
                "Correr, Saltar, Lanzar Bola de fuego, Romper bloques."
        ));

        heroes.add(new HeroData(
                "drawable/peach90s.png",
                "Peach",
                "Princesa del Reino champiñon",
                "Correr, Saltar, Planear con la sombrilla."
        ));
        heroes.add(new HeroData(
                "drawable/toad90s.png",
                "Toad",
                "Paje del Reino champiñon y ayudante de Peach",
                "Correr, Saltar, decirte que la princesa esta en otro castillo."
        ));
    }


    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Heroes del Reino Champiñon");
        }
    }
}