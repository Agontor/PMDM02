package gonzaleztorralbo.arturo.pmdm02;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import gonzaleztorralbo.arturo.pmdm02.databinding.HeroDetailFragmentBinding;

public class HeroDetailFragment extends Fragment {

    private HeroDetailFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        binding = HeroDetailFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener datos del argumento que inicia este fragmento
        if (getArguments() != null) {
            String imagen = getArguments().getString("imagen");
            String nombre = getArguments().getString("nombre");
            String descripcion = getArguments().getString("descripcion");
            String habilidades = getArguments().getString("habilidades");

            // Asignar los datos a los componentes
            binding.imagen.setTag(imagen);
            binding.nombre.setText(nombre);
            binding.descripcion.setText(descripcion);
            binding.habilidades.setText(habilidades);
            Toast.makeText(getContext(), "Se ha seleccionado el personaje " + nombre + ".", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Caracteristicas de Heroe");
        }
    }
}
