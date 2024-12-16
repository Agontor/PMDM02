package gonzaleztorralbo.arturo.pmdm02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import gonzaleztorralbo.arturo.pmdm02.databinding.HeroCardviewBinding;

public class HeroRecyclerViewAdapter extends RecyclerView.Adapter<HeroViewHolder> {
    private final ArrayList<HeroData> heroes;
    private final Context context;

    public HeroRecyclerViewAdapter(ArrayList<HeroData> heroes, Context context) {
        this.heroes = heroes;
        this.context = context;
    }

    //Crea viewholder
    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HeroCardviewBinding binding = HeroCardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent,false
        );
        return new HeroViewHolder(binding);
    }

    //enlace de datos con el viewholder
    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        HeroData currentHero = this.heroes.get(position);
        holder.bind(currentHero);
        //evento click
        holder.itemView.setOnClickListener(view -> itemClicked(currentHero, view));
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    private void itemClicked(HeroData currentHero, View view) {
        ((MainActivity) context).heroClicked(currentHero, view);
    }

}
