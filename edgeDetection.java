public void edgeDetection1(int edgeDist)
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Pixel[][] orgPixels = new Picture(this).getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < pixels[0].length-1; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col+1];
                int leftPixelColorRed = leftPixel.getRed();
                int leftPixelColorGreen = leftPixel.getGreen();
                int leftPixelColorBlue = leftPixel.getBlue();
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > 
                edgeDist){
                    leftPixel.setRed(kernelAndPicRed(row,col,orgPixels));
                    leftPixel.setGreen(kernelAndPicGreen(row,col, orgPixels));
                    leftPixel.setBlue(kernelAndPicBlue(row,col, orgPixels));
                }
                else{
                    leftPixel.setColor(Color.BLACK);
                }
            }
        }
    }

    public int kernelAndPicRed(int row, int col, Pixel[][] pixels){
        int sumRed = 0;
        int [][] kernel1 = {{1,0,-1}, 
                            {2,0,-2}, 
                            {1,0,-1}};
        int [][] kernel2 = {{-1,-2,-1},
                            {0, 0, 0},
                            {1, 2, 1}};
       int r =0;
       int c = 0;
       for(int row2 = row-1 ; row2<= row + 1; row2++){
           c=0;
            for(int col2 = col -1 ; col2 <= col + 1; col2++){
                if(row2 +r-1 >= 0 && row2 +r-1  < pixels.length &&
                col2 + c -1 >= 0 && col2 + c -1 < pixels[0].length){
                int mult = 0;
                //System.out.println(r + "r");
                //System.out.println(c + "c");
                mult = kernel1[r][c] * pixels[row2+r-1][col2+c-1].getRed();
                sumRed+=mult;
                
               
            }
            c++;
        }
        r++;
    }
    return sumRed;
    }
    
    public int kernelAndPicGreen(int row, int col, Pixel[][] pixels){
        int sumGreen = 0;
        int [][] kernel1 = {{1,0,-1}, 
                            {2,0,-2}, 
                            {1,0,-1}};
        int [][] kernel2 = {{-1,-2,-1},
                            {0, 0, 0},
                            {1, 2, 1}};
       int r =0;
       int c = 0;
       for(int row2 = row-1 ; row2<= row + 1; row2++){
           c=0;
            for(int col2 = col -1 ; col2 <= col + 1; col2++){
                if(row2 +r-1 >= 0 && row2 +r-1  < pixels.length &&
                col2 + c -1 >= 0 && col2 + c -1 < pixels[0].length){
                int mult = 0;
                //System.out.println(r + "r");
                //System.out.println(c + "c");
                mult = kernel1[r][c] * pixels[row2+r-1][col2+c-1].getGreen();
                sumGreen+=mult;
                
               
            }
            c++;
        }
        r++;
    }
    return sumGreen;
    }
    
   public int kernelAndPicBlue(int row, int col, Pixel[][] pixels){
        int sumBlue = 0;
        int [][] kernel1 = {{1,0,-1}, 
                            {2,0,-2}, 
                            {1,0,-1}};
        int [][] kernel2 = {{-1,-2,-1},
                            {0, 0, 0},
                            {1, 2, 1}};
       int r =0;
       int c = 0;
       for(int row2 = row-1 ; row2<= row + 1; row2++){
           c=0;
            for(int col2 = col -1 ; col2 <= col + 1; col2++){
                if(row2 +r-1 >= 0 && row2 +r-1  < pixels.length &&
                col2 + c -1 >= 0 && col2 + c -1 < pixels[0].length){
                int mult = 0;
                //System.out.println(r + "r");
                //System.out.println(c + "c");
                mult = kernel1[r][c] * pixels[row2+r-1][col2+c-1].getBlue();
                sumBlue+=mult;
                
               
            }
            c++;
        }
        r++;
    }
    return sumBlue;
    }