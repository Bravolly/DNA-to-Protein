package dnaproject;

public class DNAProject {
  
  static public class DNA {
    public String dnaStr;
    public String dnaRvs;
    public String compli;
    public String codonStr = "";
    public String aminoAcidSqn = "";
    public String rvsAminoSqn = "";
    public String compliAminoSqn = "";
  }
  
  static public String reverseDNA(String myDNA) {
    int size = myDNA.length();
    char[] dnaAry = new char[size];
    String dnaRvs;
    
    int j = (size - 1);
    for(int i = 0; i < size; i++) {
      dnaAry[i] = myDNA.charAt(j);
      j--;
    }
    
    dnaRvs = new String(dnaAry);
    return dnaRvs;
  }
  
  static public String compliDNA(String myDNA) {
    int size = myDNA.length();
    char[] dnaAry = new char[size];
    String compli;
    
    for(int i = 0; i < size; i++) {
      if(myDNA.charAt(i) == 'A') {
        dnaAry[i] = 'T';
      } else if(myDNA.charAt(i) == 'T') {
        dnaAry[i] = 'A';
      } else if(myDNA.charAt(i) == 'G') {
        dnaAry[i] = 'C';
      } else if(myDNA.charAt(i) == 'C') {
        dnaAry[i] = 'G';
      }
    }
    
    compli = new String(dnaAry);
    return compli;
  }
  
  static public String createCodonString(String myDNA) {
    int size = myDNA.length();
    String codon = "";
    String codonStr = "";
    
    for(int i = 0; i < size - 2; i++) {
      codon = String.valueOf(myDNA.charAt(i))
              + String.valueOf(myDNA.charAt(i+1))
              + String.valueOf(myDNA.charAt(i+2));
      
      if(codon.equals("ATG")) {
        for(int j = i; j < size - 2; j += 3) {
          codon = String.valueOf(myDNA.charAt(j))
                  + String.valueOf(myDNA.charAt(j+1))
                  + String.valueOf(myDNA.charAt(j+2));
          
          if (!(codon.equals("TAA") || codon.equals("TGA")
              || codon.equals("TAG"))) {
            codonStr += codon;
          }
          
          if (codon.equals("TAA") || codon.equals("TGA")
              || codon.equals("TAG")) {
            codonStr += codon;
            return codonStr;
          }
        }
      }
    }
    return codonStr;
  }
  
  static public String translateCodons(String myCodonStr) {
    String aminoAcidSqn = "";
    int size = myCodonStr.length();
    
    int arySize = myCodonStr.length() / 3;
    String[] codonAry = new String[arySize];
    
    int k = 0;
    
    for(int i = 0; i < arySize; i++) {
      codonAry[i] = String.valueOf(myCodonStr.charAt(k))
                    + String.valueOf(myCodonStr.charAt(k+1))
                    + String.valueOf(myCodonStr.charAt(k+2));
      
      k+=3;
    }
    
    int j = 0;
    for(int i = 0; i < arySize; i++) {
      if(codonAry[i].charAt(j) == 'A') {
        
        if(codonAry[i].charAt(j+1) == 'A') {
          
          if(codonAry[i].charAt(j+2) == 'A') {
            aminoAcidSqn += "K";
          } else if(codonAry[i].charAt(j+2) == 'C') {
            aminoAcidSqn += "N";
          } else if(codonAry[i].charAt(j+2) == 'G') {
            aminoAcidSqn += "K";
          } else if(codonAry[i].charAt(j+2) == 'T') {
            aminoAcidSqn += "N";
          }
          
        } else if(codonAry[i].charAt(j+1) == 'C') {
          
          if(codonAry[i].charAt(j+2) == 'A') {
            aminoAcidSqn += "T";
          } else if(codonAry[i].charAt(j+2) == 'C') {
            aminoAcidSqn += "T";
          } else if(codonAry[i].charAt(j+2) == 'G') {
            aminoAcidSqn += "T";
          } else if(codonAry[i].charAt(j+2) == 'T') {
            aminoAcidSqn += "T";
          }
          
        } else if(codonAry[i].charAt(j+1) == 'G') {
          
          if(codonAry[i].charAt(j+2) == 'A') {
            aminoAcidSqn += "R";
          } else if(codonAry[i].charAt(j+2) == 'C') {
            aminoAcidSqn += "S";
          } else if(codonAry[i].charAt(j+2) == 'G') {
            aminoAcidSqn += "R";
          } else if(codonAry[i].charAt(j+2) == 'T') {
            aminoAcidSqn += "S";
          }
          
        } else if(codonAry[i].charAt(j+1) == 'T') {
          
          if(codonAry[i].charAt(j+2) == 'A') {
            aminoAcidSqn += "I";
          } else if(codonAry[i].charAt(j+2) == 'C') {
            aminoAcidSqn += "I";
          } else if(codonAry[i].charAt(j+2) == 'G') {
            aminoAcidSqn += "M";
          } else if(codonAry[i].charAt(j+2) == 'T') {
            aminoAcidSqn += "I";
          }
          
        }
      } else if(codonAry[i].charAt(j) == 'C') {
        
        if(codonAry[i].charAt(j+1) == 'A') {
          
          if(codonAry[i].charAt(j+2) == 'A') {
            aminoAcidSqn += "Q";
          } else if(codonAry[i].charAt(j+2) == 'C') {
            aminoAcidSqn += "H";
          } else if(codonAry[i].charAt(j+2) == 'G') {
            aminoAcidSqn += "Q";
          } else if(codonAry[i].charAt(j+2) == 'T') {
            aminoAcidSqn += "H";
          }
          
        } else if(codonAry[i].charAt(j+1) == 'C') {
          
          if(codonAry[i].charAt(j+2) == 'A') {
            aminoAcidSqn += "P";
          } else if(codonAry[i].charAt(j+2) == 'C') {
            aminoAcidSqn += "P";
          } else if(codonAry[i].charAt(j+2) == 'G') {
            aminoAcidSqn += "P";
          } else if(codonAry[i].charAt(j+2) == 'T') {
            aminoAcidSqn += "P";
          }
          
        } else if(codonAry[i].charAt(j+1) == 'G') {
          
          if(codonAry[i].charAt(j+2) == 'A') {
            aminoAcidSqn += "R";
          } else if(codonAry[i].charAt(j+2) == 'C') {
            aminoAcidSqn += "R";
          } else if(codonAry[i].charAt(j+2) == 'G') {
            aminoAcidSqn += "R";
          } else if(codonAry[i].charAt(j+2) == 'T') {
            aminoAcidSqn += "R";
          }
          
        } else if(codonAry[i].charAt(j+1) == 'T') {
          
          if(codonAry[i].charAt(j+2) == 'A') {
            aminoAcidSqn += "L";
          } else if(codonAry[i].charAt(j+2) == 'C') {
            aminoAcidSqn += "L";
          } else if(codonAry[i].charAt(j+2) == 'G') {
            aminoAcidSqn += "L";
          } else if(codonAry[i].charAt(j+2) == 'T') {
            aminoAcidSqn += "L";
          }
          
        }
      } else if(codonAry[i].charAt(j) == 'G') {
        
        if(codonAry[i].charAt(j+1) == 'A') {
          
          if(codonAry[i].charAt(j+2) == 'A') {
            aminoAcidSqn += "E";
          } else if(codonAry[i].charAt(j+2) == 'C') {
            aminoAcidSqn += "D";
          } else if(codonAry[i].charAt(j+2) == 'G') {
            aminoAcidSqn += "E";
          } else if(codonAry[i].charAt(j+2) == 'T') {
            aminoAcidSqn += "D";
          }
          
        } else if(codonAry[i].charAt(j+1) == 'C') {
          
          if(codonAry[i].charAt(j+2) == 'A') {
            aminoAcidSqn += "A";
          } else if(codonAry[i].charAt(j+2) == 'C') {
            aminoAcidSqn += "A";
          } else if(codonAry[i].charAt(j+2) == 'G') {
            aminoAcidSqn += "A";
          } else if(codonAry[i].charAt(j+2) == 'T') {
            aminoAcidSqn += "A";
          }
          
        } else if(codonAry[i].charAt(j+1) == 'G') {
          
          if(codonAry[i].charAt(j+2) == 'A') {
            aminoAcidSqn += "G";
          } else if(codonAry[i].charAt(j+2) == 'C') {
            aminoAcidSqn += "G";
          } else if(codonAry[i].charAt(j+2) == 'G') {
            aminoAcidSqn += "G";
          } else if(codonAry[i].charAt(j+2) == 'T') {
            aminoAcidSqn += "G";
          }
          
        } else if(codonAry[i].charAt(j+1) == 'T') {
          
          if(codonAry[i].charAt(j+2) == 'A') {
            aminoAcidSqn += "V";
          } else if(codonAry[i].charAt(j+2) == 'C') {
            aminoAcidSqn += "V";
          } else if(codonAry[i].charAt(j+2) == 'G') {
            aminoAcidSqn += "V";
          } else if(codonAry[i].charAt(j+2) == 'T') {
            aminoAcidSqn += "V";
          }
          
        }
      } else if(codonAry[i].charAt(j) == 'T') {
        
        if(codonAry[i].charAt(j+1) == 'A') {
          if(codonAry[i].charAt(j+2) == 'A') {
            aminoAcidSqn += "";
          } else if(codonAry[i].charAt(j+2) == 'C') {
            aminoAcidSqn += "Y";
          } else if(codonAry[i].charAt(j+2) == 'G') {
            aminoAcidSqn += "";
          } else if(codonAry[i].charAt(j+2) == 'T') {
            aminoAcidSqn += "Y";
          }
          
        } else if(codonAry[i].charAt(j+1) == 'C') {
          
          if(codonAry[i].charAt(j+2) == 'A') {
            aminoAcidSqn += "S";
          } else if(codonAry[i].charAt(j+2) == 'C') {
            aminoAcidSqn += "S";
          } else if(codonAry[i].charAt(j+2) == 'G') {
            aminoAcidSqn += "S";
          } else if(codonAry[i].charAt(j+2) == 'T') {
            aminoAcidSqn += "S";
          }
          
        } else if(codonAry[i].charAt(j+1) == 'G') {
          
          if(codonAry[i].charAt(j+2) == 'A') {
            aminoAcidSqn += "";
          } else if(codonAry[i].charAt(j+2) == 'C') {
            aminoAcidSqn += "C";
          } else if(codonAry[i].charAt(j+2) == 'G') {
            aminoAcidSqn += "W";
          } else if(codonAry[i].charAt(j+2) == 'T') {
            aminoAcidSqn += "C";
          }
          
        } else if(codonAry[i].charAt(j+1) == 'T') {
          
          if(codonAry[i].charAt(j+2) == 'A') {
            aminoAcidSqn += "L";
          } else if(codonAry[i].charAt(j+2) == 'C') {
            aminoAcidSqn += "F";
          } else if(codonAry[i].charAt(j+2) == 'G') {
            aminoAcidSqn += "L";
          } else if(codonAry[i].charAt(j+2) == 'T') {
            aminoAcidSqn += "F";
          }
          
        }
      }
    }
    return aminoAcidSqn;
  }
  
}
