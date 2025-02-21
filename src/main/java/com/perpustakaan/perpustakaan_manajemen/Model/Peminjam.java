package com.perpustakaan.perpustakaan_manajemen.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Peminjam {
    @Id
    private String noKtp;

    private String nama;

    @Column(unique = true)
    private String email;

    public Peminjam(String noKtp, String nama, String email) {
        this.noKtp = noKtp;
        this.nama = nama;
        this.email = email;
    }

    public Peminjam() {
    }

    public String getNoKtp() {
        return this.noKtp;
    }

    public String getNama() {
        return this.nama;
    }

    public String getEmail() {
        return this.email;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
