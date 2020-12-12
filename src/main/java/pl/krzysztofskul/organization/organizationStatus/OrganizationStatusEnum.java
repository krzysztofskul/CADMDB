package pl.krzysztofskul.organization.organizationStatus;

public enum  OrganizationStatusEnum {

    PLANNING {
        @Override
        public String toString() {
            return "Investor planning";
        }
    },

    DESIGNING {
        @Override
        public String toString() {
            return "Designing in progress ...";
        }
    },

    DESIGNING_FINISHED {
        @Override
        public String toString() {
            return "Designing finished";
        }
    },

    CONSTRUCTION_WORKS {
        @Override
        public String toString() {
            return "Construction works in progress ...";
        }
    },

    CONSTRUCTION_WORKS_FINISHED {
        @Override
        public String toString() {
            return "Construction works finished";
        }
    },

    IN_EXPLOITATION {
        @Override
        public String toString() {
            return "In exploitation";
        }
    }

}
