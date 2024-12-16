package gonzaleztorralbo.arturo.pmdm02;

import androidx.recyclerview.widget.RecyclerView;
import gonzaleztorralbo.arturo.pmdm02.databinding.HeroCardviewBinding;
//import com.squareup.picasso.Picasso;

public class HeroViewHolder extends RecyclerView.ViewHolder {
    private final HeroCardviewBinding binding;

    public HeroViewHolder(HeroCardviewBinding binding){
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind (HeroData hero){
        binding.imagen.setTag(hero.getImagen());
        //binding.imagen.setText(hero.getImagen());
        binding.nombre.setText(hero.getNombre());
        binding.descripcion.setText(hero.getDescripcion());
        binding.habilidades.setText(hero.getHabilidades());
        binding.executePendingBindings();

    }
}
