package com.eaglewarrior.gbooks.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.eaglewarrior.gbooks.databinding.BookItemBinding;
import com.eaglewarrior.gbooks.models.Volume;
import com.eaglewarrior.gbooks.models.VolumeInfo;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Clarence E Moore on 2023-01-23.
 * <p>
 * Description:
 */

public class BookSearchResultsAdapter extends RecyclerView.Adapter<BookSearchResultsAdapter.BookSearchResultHolder> {

    private BookItemBinding itemBinding;
    private List<Volume> results = new ArrayList<>();


    @NonNull
    @Override
    public BookSearchResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        itemBinding = BookItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new BookSearchResultHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BookSearchResultHolder holder, int position) {

        Volume volume = results.get(position);

        VolumeInfo myVolumeInfo = volume.getVolumeInfo();

        holder.binding.bookItemTitle.setText(myVolumeInfo.getTitle());
        holder.binding.bookItemPublishedDate.setText(myVolumeInfo.getPublishedDate());
        holder.binding.bookItemDescription.setText(myVolumeInfo.getDescription());

        if(myVolumeInfo.getImageLinks() != null) {
            String imageUrl = myVolumeInfo.getImageLinks().getSmallThumbnail()
                                    .replace("http://", "https://");

            Glide.with(holder.binding.getRoot())
                    .load(imageUrl)
                    .into(holder.binding.bookItemSmallThumbnail);
        }

        if(myVolumeInfo.getAuthors() != null) {
            String authors = formatAuthorsList(myVolumeInfo.getAuthors());

            holder.binding.bookItemAuthors.setText(authors);
        }
    }

    private String formatAuthorsList(List<String> authors) {

        return String.join(", ", authors);

    }

    @Override
    public int getItemCount() {

        return results.size();
    }

    public void setResults(List<Volume> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    public class BookSearchResultHolder extends RecyclerView.ViewHolder {

        private BookItemBinding binding;

        public BookSearchResultHolder(BookItemBinding binding) {
            //
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
