package net.rossharper.collectionview;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;


public class CollectionViewPresenterTest {
    private class TestItem {
        public final String itemName;

        public TestItem(String itemName) {
            this.itemName = itemName;
        }
    }
    List<TestItem> testData = Arrays.asList(new TestItem("1"), new TestItem("2"), new TestItem("3"));

    private class CollectionViewFixture implements CollectionView {

        public CollectionModel collectionModel;

        @Override
        public void setCollectionModel(CollectionModel collectionModel) {
            this.collectionModel = collectionModel;
        }
    }

    private class ItemViewModelFixture implements ItemViewModel {
        public final String itemName;

        public ItemViewModelFixture(String itemName) {
            this.itemName = itemName;
        }
    }

    @Test
    public void whenOnReady_CollectionViewUpdatedWithCollectionModel() {
        CollectionViewFixture collectionViewFixture = new CollectionViewFixture();

        ItemModelFactory itemModelFactory = new ItemModelFactory() {
            @Override
            public ItemModel createItemModel(final Object data) {
                return new ItemModel(
                        new ItemViewFactory() {
                            @Override
                            public Object createView(Object parent) {
                                return null;
                            }
                        },
                        new ItemViewBinder() {
                            @Override
                            public void bind(Object view, ItemViewModel itemViewModel) {
                            }
                        },
                        new ItemViewModelFixture(((TestItem)data).itemName));
            }
        };

        ItemModelFactoryRegistry itemModelFactoryRegistry = new ItemModelFactoryRegistry();
        itemModelFactoryRegistry.registerItemModelFactory(TestItem.class, itemModelFactory);

        CollectionViewPresenter presenter = new CollectionViewPresenter(
                collectionViewFixture,
                new DataProvider() {
                    @Override
                    public void loadData(DataProviderListener listener) {
                        listener.onLoad(testData);
                    }
                },
                new RegistryCollectionModelDataAdapter(itemModelFactoryRegistry));

        presenter.onReady();

        CollectionModel collectionModel = collectionViewFixture.collectionModel;
        assertNotNull(collectionModel);
        assertThat(collectionModel.getCount(), equalTo(3));
        for(int i = 0; i < 3; ++i) {
            ItemModel itemModel = collectionModel.getItemModel(i);
            assertNotNull(itemModel);
            assertNotNull(itemModel.getItemViewFactory());
            assertNotNull(itemModel.getItemViewBinder());
            ItemViewModel itemViewModel = itemModel.getItemViewModel();
            assertThat(itemViewModel, instanceOf(ItemViewModelFixture.class));
            ItemViewModelFixture itemViewModelFixture = (ItemViewModelFixture) itemViewModel;
            assertThat(itemViewModelFixture.itemName, equalTo(Integer.toString(i+1)));
        }
    }
}