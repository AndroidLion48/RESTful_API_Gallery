package com.eaglewarrior.gbooks.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eaglewarrior.gbooks.adapter.BookSearchResultsAdapter;
import com.eaglewarrior.gbooks.databinding.FragmentBookSearchBinding;
import com.eaglewarrior.gbooks.models.VolumesResponse;
import com.eaglewarrior.gbooks.viewmodels.BookSearchViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

public class BookSearchFragment extends Fragment {

    private FragmentBookSearchBinding binding;

    private BookSearchViewModel viewModel;
    private BookSearchResultsAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        adapter = new BookSearchResultsAdapter();
        viewModel = ViewModelProviders.of(this).get(BookSearchViewModel.class);
        viewModel.init();
        viewModel.getVolumesResponseLiveData().observe(this, new Observer<VolumesResponse>() {
            @Override
            public void onChanged(VolumesResponse volumesResponse) {

                if (volumesResponse != null) {
                    adapter.setResults(volumesResponse.getItems());
                }
            }
        });
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentBookSearchBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);


        binding.searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                performSearch();
            }
        });
        return view;
    }

    private void performSearch() {

        String keyword = binding.keywordEditText.getEditableText().toString();
        String author = binding.keywordEditText.getEditableText().toString();

        viewModel.searchVolumes(keyword, author);
    }
}
