package com.io2.service;

import com.io2.model.Brand;
import com.io2.model.Sneaker;
import com.io2.model.User;
import com.io2.repository.BrandRepository;
import com.io2.repository.SneakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Niki on 2017-04-19.
 */
@Service
public class CollectionCreatorServiceImpl implements CollectionCreatorService {

    private Map<Float, String> sizes = new TreeMap<>();
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private SneakerRepository sneakerRepository;
    @Autowired
    private FileService fileService;

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    private Map<Float, String> createSizes() {
        for (float i = 5; i < 15; i += 0.5) {
            sizes.put(i, i + " US");
        }
        return sizes;
    }

    public Map<Float, String> getSizes() {
        if (sizes.isEmpty()) {
            sizes = createSizes();
        }
        return sizes;
    }

    public Boolean addSneaker(Sneaker sneaker, MultipartFile file, Long id) throws IOException {
        if (id != null && sneakerRepository.findById(id) != null) {
            sneaker.setId(id);
        }

        User user = userService.getCurrentUser();
        sneaker.setOwner(user);
        String filename = handleFileUpload(file);
        sneaker.setFilename(filename);
        Sneaker result = sneakerRepository.save(sneaker);
        return result != null;
    }

    public String handleFileUpload(MultipartFile file) throws IOException {
        String filename = null;
        if (!file.isEmpty()) {
            filename = fileService.uploadFile(file.getInputStream());
        }
        return filename;
    }


}
