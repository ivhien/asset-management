package com.task.assetmanagement.repository.asset;

import com.task.assetmanagement.model.asset.AssetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AssetRepository extends JpaRepository<AssetModel,Long> {

    @Modifying
    @Query(value = "update tbl_asset set is_deleted = :flag where id = :id ", nativeQuery = true)
    void deleteOne(@Param("flag") boolean flagDeleted, @Param("id") Long id);
}
