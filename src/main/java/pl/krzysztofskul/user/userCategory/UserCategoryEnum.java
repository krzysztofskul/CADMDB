package pl.krzysztofskul.user.userCategory;

public enum UserCategoryEnum {

    ADMIN {
        @Override
        public String toString() {
            return "Admin";
        }
    },

    INVESTOR {
        @Override
        public String toString() {
            return "Investor";
        }
    },

    INVESTOR_GUEST {
        @Override
        public String toString() {
            return "Investor (guest)";
        }
    },

    INVESTOR_EMPLOYEE {
        @Override
        public String toString() {
            return "Investor employee";
        }
    },

    INVESTOR_EMPLOYEE_GUEST {
        @Override
        public String toString() {
            return "Investor employee (guest)";
        }
    },

    HOSPITAL_MANAGER {
        @Override
        public String toString() {
            return "Hospital manager";
        }
    },

    HOSPITAL_DEPARTMENT_MANAGER {
        @Override
        public String toString() {
            return "Department manager";
        }
    },

    HOSPITAL_DEPARTMENT_ROOM_MANAGER {
        @Override
        public String toString() {
            return "Room manager";
        }
    },

    HOSPITAL_MANAGER_GUEST {
        @Override
        public String toString() {
            return "Hospital manager (guest)";
        }
    },

    HOSPITAL_DEPARTMENT_MANAGER_GUEST {
        @Override
        public String toString() {
            return "Department manager (guest)";
        }
    },

    HOSPITAL_DEPARTMENT_ROOM_MANAGER_GUEST {
        @Override
        public String toString() {
            return "Room manager (guest)";
        }
    },

    HOSPITAL_EMPLOYEE {
        @Override
        public String toString() {
            return "Hospital employee";
        }
    },

    HOSPITAL_EMPLOYEE_GUEST {
        @Override
        public String toString() {
            return "Hospital employee (guest)";
        }
    },

    MANUFACTURER {
        @Override
        public String toString() {
            return "Manufacturer";
        }
    },

    MANUFACTURER_GUEST {
        @Override
        public String toString() {
            return "Manufacturer (guest)";
        }
    },

    MANUFACTURER_EMPLOYEE {
        @Override
        public String toString() {
            return "Manufacturer employee";
        }
    },

    MANUFACTURER_EMPLOYEE_GUEST {
        @Override
        public String toString() {
            return "Manufacturer employee (guest)";
        }
    },

    DESIGNER {
        @Override
        public String toString() {
            return "Designer";
        }
    },

    DESIGNER_GUEST {
        @Override
        public String toString() {
            return "Designer (guest)";
        }
    },

    DESIGNER_EMPLOYEE {
        @Override
        public String toString() {
            return "Designer employee";
        }
    },

    DESIGNER_EMPLOYEE_GUEST {
        @Override
        public String toString() {
            return "Designer employee (guest)";
        }
    },

    BUILDING_CONTRACTOR {
        @Override
        public String toString() {
            return "Building contractor";
        }
    },

    BUILDING_CONTRACTOR_GUEST {
        @Override
        public String toString() {
            return "Building contractor (guest)";
        }
    },

    BUILDING_CONTRACTOR_EMPLOYEE {
        @Override
        public String toString() {
            return "Building contractor employee";
        }
    },

    BUILDING_CONTRACTOR_EMPLOYEE_GUEST {
        @Override
        public String toString() {
            return "Building contractor employee (guest)";
        }
    }

}
