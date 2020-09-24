package pl.krzysztofskul.product;

import java.util.Random;

public enum InstallationType {

    FIXED_FLOOR {
        @Override
        public String toString() {
            return "Fixed to the floor";
        }
    },
    FIXED_WALL {
        @Override
        public String toString() {
            return "Fixed to the wall";
        }
    },
    FIXED_CEILING {
        @Override
        public String toString() {
            return "Fixed to the ceiling";
        }
    },
    STANDALONE_FLOOR {
        @Override
        public String toString() {
            return "Standalone on the floor";
        }
    },
    STANDALONE_TABLETOP {
        @Override
        public String toString() {
            return "Standalone on the tabletop";
        }
    },
    BIULT_IN {
        @Override
        public String toString() {
            return "Built into other device";
        }
    },
    MOBILE {
        @Override
        public String toString() {
            return "Mobile on wheels";
        }
    },
    PORTABLE {
        @Override
        public String toString() {
            return "Portable or pocket (lightweight)";
        }

    };

    public static InstallationType getRandomInstallationType() {
        Random random = new Random();
        switch (random.nextInt(8)+1) {
            case 1: {
                return  InstallationType.FIXED_FLOOR;
            }
            case 2: {
                return  InstallationType.FIXED_WALL;
            }
            case 3: {
                return  InstallationType.FIXED_CEILING;
            }
            case 4: {
                return  InstallationType.STANDALONE_FLOOR;
            }
            case 5: {
                return  InstallationType.STANDALONE_TABLETOP;
            }
            case 6: {
                return  InstallationType.BIULT_IN;
            }
            case 7: {
                return  InstallationType.MOBILE;
            }
            case 8: {
                return  InstallationType.PORTABLE;
            }
            default: {
                return null;
            }
        }
    }
}
