class FurnitureApp{
    public static void main(String []args){

        //Bed bed=new Bed();

        //you must specify a package qualified class name to use class
        furnitures.bedroom.Bed bed=new furnitures.bedroom.Bed();       
        System.out.printf("The price of %s is %d\n",bed, bed.price());

       furnitures.livingroom.Chair chair=new furnitures.livingroom.Chair();       
        System.out.printf("The price of %s is %d\n",chair, chair.price());

       furnitures.livingroom.Table table=new furnitures.livingroom.Table();       
        System.out.printf("The price of %s is %d\n",table, table.price());
 
       furnitures.office.Chair chair1=new furnitures.office.Chair();       
        System.out.printf("The price of %s is %d\n",chair1, chair1.price());

     furnitures.office.Table table1=new furnitures.office.Table();       
        System.out.printf("The price of %s is %d\n",table1, table1.price());

    }

} 