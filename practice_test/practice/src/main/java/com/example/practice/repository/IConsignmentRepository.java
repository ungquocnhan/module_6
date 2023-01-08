package com.example.practice.repository;

import com.example.practice.model.Consignment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IConsignmentRepository extends JpaRepository<Consignment, Integer> {
//    @Query(value = "select c.id, c.code, c.amount, c.import_date as importDate, c.production_date as productionDate, c.expiration_date as expirationDate, p.name, p.cost, p.unit from test_practice_module_5.consignment c join test_practice_module_5.product p on c.product_id = p.id where c.flag = true",
//    countQuery = "select * from (select c.id, c.code, c.amount, c.import_date as importDate, c.production_date as productionDate, c.expiration_date as expirationDate, p.name, p.cost, p.unit from consignment c join product p on c.product_id = p.id where c.flag = true) as count", nativeQuery = true)
//    Page<Consignment> getAll(Pageable pageable);

//    @Query(value = "select c.*, p.name, p.cost, p.unit from test_practice_module_5.consignment c join test_practice_module_5.product p on c.product_id = p.id where c.flag = true",
//            countQuery = "select * from (select c.*, p.name, p.cost, p.unit from test_practice_module_5.consignment c join test_practice_module_5.product p on c.product_id = p.id where c.flag = true) as count", nativeQuery = true)
//    Page<Consignment> getAll(Pageable pageable);

    @Query(value = "select c.* from test_practice_module_5.consignment c where c.flag = true",
            countQuery = "select * from (select c.* from test_practice_module_5.consignment c  where c.flag = true) as count", nativeQuery = true)
    Page<Consignment> getAll(Pageable pageable);

    @Modifying
    @Query(value = "insert into consignment (code, amount, import_date, production_date, expiration_date, product_id, flag) " +
            "value (:code, :amount, :importDate, :productionDate, :expirationDate, :productId, :flag)", nativeQuery = true)
    @Transactional
    void create(@Param("code") String code, @Param("amount") int amount, @Param("importDate") String importDate, @Param("productionDate") String productionDate,
                @Param("expirationDate") String expirationDate, @Param("productId") int productId, @Param("flag") boolean flag);

    @Query(value = "select * from test_practice_module_5.consignment where id = :id", nativeQuery = true)
    Optional<Consignment> findId(@Param("id") int id);

    @Modifying
    @Query(value = "update consignment set flag = false where id = :id", nativeQuery = true)
    @Transactional
    void delete(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "update consignment as c " +
            "set c.code = ?1, c.amount = ?2, c.import_date = ?3" +
            ",c.production_date = ?4, c.expiration_date = ?5, c.product_id = ?6 where c.id = ?7", nativeQuery = true)
    void edit(String code, int amount, String importDate, String productionDate, String expirationDate, int productId, int id);

    @Modifying
    @Query(value = "SELECT c.*, p.name as productName FROM test_practice_module_5.consignment as c JOIN product p on p.id = c.product_id WHERE c.flag = true AND (c.code LIKE concat('%' , :code , '%') AND c.import_date LIKE concat('%', :importDate ,'%')  AND p.name LIKE concat('%', :productName, '%'))", nativeQuery = true)
    List<Consignment> search(@Param("code") String code, @Param("importDate") String importDate, @Param("productName") String productName);
}
