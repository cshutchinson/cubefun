package com.hutch.cubeFun.service;

import com.hutch.cubeFun.model.Cublet;
import com.hutch.cubeFun.model.Slice;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class CubeFunService {
    public int analyze(Slice[] slice){
        System.out.println("getColumnString(slice[0].getRow()[0].getColumn()) = " + getColumnString(slice[0].getRow()[0].getColumn()));
        System.out.println("face: " + getFaceString(slice));
        System.out.println("zero: " + findZero(getFaceString(slice)).toString());

        String faceString = getFaceString(slice);
        return calculateSum(findZero(faceString), faceString);
    }

    private String getColumnString(Cublet[] column){
        return Arrays.stream(column)
                .map(cublet -> cublet.getValue().toString())
                .collect(Collectors.joining());
    }

    private String getFaceString(Slice[] slice){
        return Arrays.stream(slice)
                .flatMap(elem -> Arrays.stream(elem.getRow()))
                .map(elem -> getColumnString(elem.getColumn()))
                .collect(Collectors.joining());
    }

    private Integer findZero(String face){
        return face.indexOf("0");
    }

    private int calculateSum(int zeroPosition, String face){

        String newFace = face;
        for(int i=face.length(); i<27; i++){
            newFace= newFace.concat("0");
        }
        int[] faceVals = Arrays.stream(newFace.split(""))
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue)
                .toArray();

        switch (zeroPosition){
            case 0:
                return faceVals[1]+faceVals[3] + faceVals[9];
            case 1:
                return faceVals[0]+faceVals[2]+faceVals[4]+ faceVals[10];
            case 2:
                return faceVals[1]+faceVals[5]+ faceVals[11];
            case 3:
                return faceVals[0]+faceVals[4]+faceVals[6]+ faceVals[12];
            case 4:
                return faceVals[1]+faceVals[3]+faceVals[5]+faceVals[7]+ faceVals[13];
            case 5:
                return faceVals[2]+faceVals[4]+faceVals[8]+ faceVals[14];
            case 6:
                return faceVals[3]+faceVals[7]+ faceVals[15];
            case 7:
                return faceVals[4]+faceVals[6]+faceVals[8]+ faceVals[16];
            case 8:
                return faceVals[5]+faceVals[7]+ faceVals[17];

            case 9:
                return faceVals[10] + faceVals[12]+ faceVals[0]+ faceVals[18];
            case 10:
                return faceVals[9] + faceVals[11] + faceVals[13]+ faceVals[1]+ faceVals[19];
            case 11:
                return faceVals[10] + faceVals[14]+ faceVals[2]+ faceVals[20];
            case 12:
                return faceVals[9] + faceVals[13] + faceVals[15]+ faceVals[3]+ faceVals[21];
            case 13:
                return faceVals[10] + faceVals[12] + faceVals[14] + faceVals[16]+ faceVals[4]+ faceVals[22];
            case 14:
                return faceVals[11] + faceVals[13] + faceVals[17]+ faceVals[5]+ faceVals[23];
            case 15:
                return faceVals[12] + faceVals[16]+ faceVals[6]+ faceVals[24];
            case 16:
                return faceVals[13] + faceVals[15] + faceVals[17]+ faceVals[7]+ faceVals[25];
            case 17:
                return faceVals[14] + faceVals[16]+ faceVals[8]+ faceVals[26];

            case 18:
                return faceVals[19] + faceVals[21]+ faceVals[9];
            case 19:
                return faceVals[18] + faceVals[20] + faceVals[22]+ faceVals[10];
            case 20:
                return faceVals[19] + faceVals[23]+ faceVals[11];
            case 21:
                return faceVals[18] + faceVals[22] + faceVals[24]+ faceVals[12];
            case 22:
                return faceVals[19] + faceVals[21] + faceVals[23] + faceVals[25]+ faceVals[13];
            case 23:
                return faceVals[20] + faceVals[22] + faceVals[26]+ faceVals[14];
            case 24:
                return faceVals[21] + faceVals[25]+ faceVals[15];
            case 25:
                return faceVals[22] + faceVals[24] + faceVals[26]+ faceVals[16];
            case 26:
                return faceVals[23] + faceVals[25]+ faceVals[17];

            default:
                return 0;
        }
    }

}
