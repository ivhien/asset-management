package com.task.assetmanagement.form.asset;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AssetForm {
    private String kodeAsset; //Variabel untuk field kode_asset
    private String namaAsset; //Variabel untuk field nam_asset
    private String spekAsset; //Variabel untuk field spesifikasi_asset
    private String jenisAsset; //Variabel untuk field jenis_asset
    private String lokasiAsset; //Variabel untuk field lokasi_asset
    private String dic; //Variabel untuk field dept_in_charge
    private Integer pic; //Variabel untuk field person_in_charge
    private Integer qty;
    private String satuan;
    private String attachment;
    private String qrCode;
    private LocalDate buyDate;
    private String currency;
    private String useFul;
    private Long priceAsset;
}
