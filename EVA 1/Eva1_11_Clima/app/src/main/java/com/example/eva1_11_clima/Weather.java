package com.example.eva1_11_clima;

public class Weather {

    /* Nombre de la ciudad - String
        Temperatura - int
        descripcion del clima - String
        Imagen - int
     */
    private String city, desc;
    private int temp, image;

    public Weather() {
        this.city = "";
        this.temp = 0;
        this.image = -1;
        this.desc = "";
    }

    public Weather(String city, String desc, int temp, int image) {
        this.city = city;
        this.desc = desc;
        this.temp = temp;
        this.image = image;
    }


    public String getCity() {
        return city;
    }

    public String getDesc() {
        return desc;
    }

    public int getTemp() {
        return temp;
    }

    public int getImage() {
        return image;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
