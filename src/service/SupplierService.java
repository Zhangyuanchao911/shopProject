package service;

import model.Supplier;

import java.util.List;

public interface SupplierService {
    int add(Supplier supplier);
    int delete(int id);
    int update(Supplier supplier);
    List<Supplier> listQuery();
    Supplier query();
}
