package com.example.miniprojetand;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {
    private List<Hotel> hotelList;
    private List<Hotel> filteredHotelList;

    public HotelAdapter(List<Hotel> hotelList) {
        this.hotelList = hotelList;
        this.filteredHotelList = hotelList; // Initialement, les deux listes sont identiques
    }

    @Override
    public HotelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflater du layout item_hotel
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ligne, parent, false);
        return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HotelViewHolder holder, int position) {
        // Récupérer les données de l'hôtel
        Hotel hotel = filteredHotelList.get(position);

        // Remplir les TextViews avec les données de l'hôtel
        holder.nameTextView.setText(hotel.getName());
        holder.locationTextView.setText(hotel.getLocation());
        holder.priceTextView.setText(hotel.getPrice());

        // Charger l'image depuis une URL ou Firebase Storage avec Glide (si l'image est stockée en ligne)
        Glide.with(holder.itemView.getContext())
                .load(hotel.getImageUrl())  // Assurez-vous que getImageUrl() renvoie une URL valide
                .into(holder.hotelImageView);
    }

    @Override
    public int getItemCount() {
        return filteredHotelList.size();
    }

    // Fonction de filtrage pour la recherche
    public void filter(String query) {
        if (query.isEmpty()) {
            filteredHotelList = hotelList;
        } else {
            filteredHotelList.clear();
            for (Hotel hotel : hotelList) {
                if (hotel.getName().toLowerCase().contains(query.toLowerCase())) {
                    filteredHotelList.add(hotel);
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class HotelViewHolder extends RecyclerView.ViewHolder {
        ImageView hotelImageView;
        TextView nameTextView, locationTextView, priceTextView;

        public HotelViewHolder(View itemView) {
            super(itemView);
            hotelImageView = itemView.findViewById(R.id.hotelImageView);  // Correctement lié à ImageView
            nameTextView = itemView.findViewById(R.id.hotelNameTextView);  // Correctement lié à TextView
            locationTextView = itemView.findViewById(R.id.hotelLocationTextView);  // Correctement lié à TextView
            priceTextView = itemView.findViewById(R.id.hotelPriceTextView);  // Correctement lié à TextView
        }
    }
}
