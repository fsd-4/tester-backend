package net.idrok.tester.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.idrok.tester.entity.Savol;
import net.idrok.tester.service.dto.SavolDTO;

public interface SavolService extends CommonService<Savol>{
    /**
     * Bu SavolDTO qaytaruvchi metod
     * @param key - Stirng turida
     * @param pageable - Pageable turida
     * @return SavolDTO turidagi Page qaytariladi
     */
    public Page<SavolDTO> getAll(String key, Pageable pageable);
    
   
}
