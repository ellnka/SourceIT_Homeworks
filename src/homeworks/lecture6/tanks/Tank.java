package homeworks.lecture6.tanks;


public class Tank {
    private Gun gun;
    private int shellsQuantity;

    public Tank(int shellsQuantity) {
        this.gun = new Gun();
        this.shellsQuantity = shellsQuantity;
    }

    public void fire() {
        try {
            gun.fire();
        } catch (TankException tankException) {
            System.err.println(tankException.getMessage());
        }
    }

    public void load() throws TankException {
        try {
            if (!gun.isLoaded()) {
                gun.load();
            } else {
                throw new TankException("Gun is already loaded");
            }
        } catch (TankException tankException) {
            System.err.println(tankException.getMessage());
        }
    }

    public void reload(int shells) {
        shellsQuantity += shells;
    }

    public class Gun {
        private boolean loaded;

        public Gun() {
            this.loaded = false;
        }

        public boolean isLoaded() {
            return loaded;
        }

        public void setLoaded(boolean loaded) {
            try {
                if (shellsQuantity > 0) {
                    this.loaded = loaded;
                    shellsQuantity--;
                } else {
                    throw new TankException("Out of ammo! Go to the base!!!");
                }
            } catch (TankException tankException) {
                System.err.println(tankException.getMessage());
            }
        }

        public void load() throws TankException {
            try {
                if (!isLoaded()) {
                    setLoaded(true);
                } else {
                    throw new TankException("Already loaded, can't load!");
                }
            } catch (TankException tankException) {
                System.err.println(tankException.getMessage());
            }
        }

        public void fire() throws TankException {
            try {
                if (isLoaded()) {
                    System.out.println("Fire!!!!");
                    setLoaded(false);
                } else {
                    throw new TankException("Have no shell in a gun, please load!!");
                }
            } catch (TankException tankException) {
                System.err.println(tankException.getMessage());
            }
        }
    }

}
