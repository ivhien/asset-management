package com.task.assetmanagement.service.svcimpl;

import com.task.assetmanagement.common.ResponseUtil;
import com.task.assetmanagement.constant.MessageConstant;
import com.task.assetmanagement.form.asset.AssetForm;
import com.task.assetmanagement.model.asset.AssetModel;
import com.task.assetmanagement.repository.asset.AssetRepository;
import com.task.assetmanagement.service.svc.AssetSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AssetSvcImpl implements AssetSvc {
    private final AssetRepository assetRepository;

    @Autowired
    public AssetSvcImpl(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }
    
    @Override
    public AssetModel create(AssetForm form){
        return assetRepository.save(asset(form));
    }

    @Override
    public ResponseEntity<Object> getAll() {
//        return assetRepository.findAll();
        try {
            List<AssetModel> opt = assetRepository.findAll();
            if (!opt.isEmpty()) return ResponseUtil.build(MessageConstant.SUCCESS, assetRepository.findAll(), HttpStatus.OK);
                    return ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> findById(Long id){
//        Optional<AssetModel> opt = assetRepository.findById(id);
//        return opt.orElse(null);

        try {
            Optional<AssetModel> opt = assetRepository.findById(id);
            return opt.map(assetModel -> ResponseUtil.build(MessageConstant.SUCCESS, assetModel, HttpStatus.OK))
                    .orElseGet(() -> ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND));
        }catch (Exception e){
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> updateById(AssetForm form, Long id) {
        try {
            Optional<AssetModel> getById = assetRepository.findById(id);
            if (!getById.isPresent()) return ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
            AssetModel getAsset = getById.get();
            getAsset.setKodeAsset(form.getKodeAsset());
            getAsset.setNamaAsset(form.getNamaAsset());
            getAsset.setLokasiAsset(form.getLokasiAsset());
            getAsset.setPic(form.getPic());
            getAsset.setPriceAsset(form.getPriceAsset());
            getAsset.setQrCode(form.getQrCode());
            getAsset.setSpekAsset(form.getSpekAsset());
            getAsset.setUseFul(form.getUseFul());
            getAsset.setDic(form.getDic());
            getAsset.setJenisAsset(form.getJenisAsset());
            getAsset.setQty(form.getQty());
            getAsset.setSatuan(form.getSatuan());
            getAsset.setCurrency(form.getCurrency());
            getAsset.setBuyDate(form.getBuyDate());
            assetRepository.save(getAsset);
            return ResponseUtil.build(MessageConstant.SUCCESS_UPDATE, assetRepository.save(getAsset), HttpStatus.OK);
        } catch (Exception e){
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Object> deleteById(Long id) {
        try {
        Optional<AssetModel> getData = assetRepository.findById(id);
        if (!getData.isPresent()) return ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
        AssetModel getAsset = getData.get();
        getAsset.setIsDeleted(true);
        getAsset.setUpdatedAt(LocalDateTime.now());
        assetRepository.save(getAsset);
        return ResponseUtil.build(MessageConstant.SUCCESS_DELETE, assetRepository.save(getAsset), HttpStatus.OK);
        } catch (Exception e){
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<Object> deleteOne(Long id) {
        try {
            Optional<AssetModel> getData = assetRepository.findById(id);
            if (!getData.isPresent()) return ResponseUtil.build(MessageConstant.DATA_NOT_FOUND, null, HttpStatus.NOT_FOUND);
            assetRepository.deleteOne(true,id);
            return ResponseUtil.build(MessageConstant.SUCCESS_DELETE, null, HttpStatus.OK);
        } catch (Exception e){
            return ResponseUtil.build(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private AssetModel asset(AssetForm form) {
            AssetModel asset = new AssetModel();
            asset.setKodeAsset(form.getKodeAsset());
            asset.setNamaAsset(form.getNamaAsset());
            asset.setLokasiAsset(form.getLokasiAsset());
            asset.setPic(form.getPic());
            asset.setPriceAsset(form.getPriceAsset());
            asset.setQrCode(form.getQrCode());
            asset.setSpekAsset(form.getSpekAsset());
            asset.setUseFul(form.getUseFul());
            asset.setDic(form.getDic());
            asset.setJenisAsset(form.getJenisAsset());
            asset.setQty(form.getQty());
            asset.setSatuan(form.getSatuan());
            asset.setCurrency(form.getCurrency());
            asset.setBuyDate(form.getBuyDate());

            return asset;
    }


}
