package peaksoft.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.repository.HouseRepository;
import peaksoft.service.HouseService;
@Service
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;
@Autowired
    public HouseServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public void assignHouseToUser(Long userId, Long houseId) {

    }
}
