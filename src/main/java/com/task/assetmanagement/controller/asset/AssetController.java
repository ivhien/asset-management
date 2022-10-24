package com.task.assetmanagement.controller.asset;

import com.task.assetmanagement.form.asset.AssetForm;
import com.task.assetmanagement.model.asset.AssetModel;
import com.task.assetmanagement.service.svc.AssetSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/asset")
public class AssetController {

    private final AssetSvc assetSvc;

    @Autowired
    public AssetController(AssetSvc assetSvc) {
        this.assetSvc = assetSvc;
    }


    @PostMapping(value = "/add-asset")
    public AssetModel create(@RequestBody AssetForm form){
        return assetSvc.create(form);
    }

    @GetMapping(value = "/get-data-asset")
    public ResponseEntity<Object> getAll(){
        return assetSvc.getAll();
    }

    @GetMapping(value = "/get-data-by/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        return assetSvc.findById(id);
    }

    @PostMapping(value = "/update-data-asset/{id}")
    public ResponseEntity<Object> updateById(@RequestBody AssetForm form, @PathVariable Long id){
        return assetSvc.updateById(form,id);
    }

    //dengan method update
    @DeleteMapping(value = "/delete-data-asset/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id){
        return assetSvc.deleteById(id);
    }

    //dengan method update query native
    @DeleteMapping(value = "/delete-data-one/{id}")
    public ResponseEntity<Object> deleteOne(@PathVariable Long id){
        return assetSvc.deleteOne(id);
    }

}
