package com.kraft.tests.day19_DDF;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _3_DataProviderDemo {

    @DataProvider (name = "studentNotes")
    public Object[][] testData(){
        Object [][] notes={
                {"Hasan Sarı",70,100},
                {"Emre Koçak",80,98},
                {"Hanife Kara",90,95},
                {"Burhan Atlı",87,98},
                {"Şule Sarı",100,93},

        };
        return notes;
    }

    @Test(dataProvider ="studentNotes" )
    public void test1(String fullName, int visaNote, int finalNote){

        System.out.println(fullName+ " "+ visaNote+" "+finalNote+ " Yıl Sonu Notu "+(visaNote*.4+finalNote*.6));

    }
}
