package com.eaglewarrior.gbooks.viewmodels;

import android.app.Application;

import com.eaglewarrior.gbooks.models.VolumesResponse;
import com.eaglewarrior.gbooks.repositories.BookRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import static com.eaglewarrior.gbooks.secret.Credentials.GOOGLE_API_KEY;

/**
 * Created by Clarence E Moore on 2023-01-21.
 * <p>
 * Description:
 */
    public class BookSearchViewModel extends AndroidViewModel {
        private BookRepository bookRepository;
        private LiveData<VolumesResponse> volumesResponseLiveData;

        public BookSearchViewModel(@NonNull Application application) {
            super(application);
        }

        public void init() {
            bookRepository = new BookRepository();
            volumesResponseLiveData = bookRepository.getVolumesResponseLiveData();
        }

        public void searchVolumes(String keyword, String author) {

            bookRepository.searchVolumes(keyword, author, GOOGLE_API_KEY);
        }

        public LiveData<VolumesResponse> getVolumesResponseLiveData() {
            return volumesResponseLiveData;
        }
}
