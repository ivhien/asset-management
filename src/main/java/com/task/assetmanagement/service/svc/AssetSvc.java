package com.task.assetmanagement.service.svc;

import com.task.assetmanagement.common.ResponseUtil;
import com.task.assetmanagement.form.asset.AssetForm;
import com.task.assetmanagement.model.asset.AssetModel;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import javax.persistence.Entity;
import java.util.List;

public interface AssetSvc {
    AssetModel create(AssetForm form);

    ResponseEntity<Object> getAll();

    ResponseEntity<Object> findById(Long id);

    ResponseEntity<Object> updateById(AssetForm form,Long id);

    ResponseEntity<Object> deleteById(Long id);

    ResponseEntity<Object> deleteOne(Long id);
}
