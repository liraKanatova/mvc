package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.service.HouseService;

@Controller
@RequestMapping("/houses")
public class HouseApi {
    private final HouseService houseService;
@Autowired
    public HouseApi(HouseService houseService) {
        this.houseService = houseService;
    }
//    @PutMapping("/assign/{userId}/{houseId}")
//    public String assign(@PathVariable("userId")Long userId,
//                         @PathVariable("houseId")Long houseId){
//    houseService.assignHouseToUser(userId,houseId);
//    return "";

    }

