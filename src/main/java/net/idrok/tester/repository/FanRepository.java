package net.idrok.tester.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.idrok.tester.entity.Fan;
import net.idrok.tester.entity.FanDaraja;

@Repository
public interface FanRepository extends JpaRepository<Fan, Long>{
    List<Fan> findAllByNomContainingOrMalumotContaining(String k1, String k2);
    
    List<Fan> findByFanDaraja(FanDaraja fandaraja);

     default List<Fan> findByFanDarajaELEMENTAR(){
        return this.findByFanDaraja(FanDaraja.ELEMENTAR);
     }


     @Query("FROM Fan f WHERE f.fanDaraja = net.idrok.tester.entity.FanDaraja.OLIY")
     List<Fan> findbyFanDarajaOLIY();

}
