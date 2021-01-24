package pl.sdacademy.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.springproject.entity.CarEntity;
import pl.sdacademy.springproject.service.CarParameter;

import java.util.List;

//inne popularne typy repository: CrudRepository, PagingAndSortingRepository
//można też nadpisywać repository (stworzyć własną implementację metod)
@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    public List<CarEntity> findByProducer(@Param("producer") String producer);

    @Query(value = "SELECT c FROM CarEntity c WHERE c.producer = :producer", nativeQuery = false)
    public List<CarEntity> customQueryByProducer(@Param("producer") String producer);

//    @Query(value = "SELECT c FROM Car c WHERE c.id = :id", nativeQuery = false)
//    @Transactional(readOnly = true)
//    public CarEntity customQuery1(@Param("id") Long id);
}
