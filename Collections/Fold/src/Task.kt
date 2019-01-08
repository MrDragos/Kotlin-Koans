// Return the set of products that were ordered by every customer
fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
    val allProducts: Set<Product> = customers.flatMap { it.orders }.flatMap { it.products }.toSet()
    return customers.fold(allProducts,
            {
                acc, customer -> customer.getOrderedProducts().intersect(acc)
            })
}

fun Customer.getOrderedProducts(): Set<Product> = orders.flatMap { it.products }.toSet()