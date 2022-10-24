package com.task.assetmanagement.model.asset;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_asset")
@NoArgsConstructor
@Where(clause = "is_deleted = false")
public class AssetModel extends BaseDao{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "kode_asset", nullable = false)
    private String kodeAsset;

    @Column(name = "nama_asset", nullable = false)
    private String namaAsset; //Variabel untuk field nam_asset

    @Column(name = "spesifikasi_asset", nullable = false)
    private String spekAsset; //Variabel untuk field spesifikasi_asset

    @Column(name = "jenis_asset", nullable = false)
    private String jenisAsset; //Variabel untuk field jenis_asset

    @Column(name = "lokasi_asset", nullable = false)
    private String lokasiAsset; //Variabel untuk field lokasi_asset

    @Column(name = "dept_in_charge", nullable = false)
    private String dic; //Variabel untuk field dept_in_charge

    @Column(name = "person_in_charge",length = 3, nullable = false)
    private Integer pic; //Variabel untuk field person_in_charge

    @Column(name = "qty", nullable = false)
    private Integer qty;

    @Column(name = "satuan", nullable = false)
    private String satuan;

    @Column(name = "attachment")
    private String attachment;

    @Column(name = "qrcode")
    private String qrCode;

    @Column(name = "buy_date")
    private LocalDate buyDate;

    @Column(name = "price_asset", nullable = false)
    private Long priceAsset;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "use_ful", nullable = false)
    private String useFul;

}
