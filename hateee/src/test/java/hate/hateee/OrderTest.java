package hate.hateee;

import com.fasterxml.jackson.databind.ObjectMapper;
import hate.hateee.forms.Status;
import hate.hateee.mdls.*;
import hate.hateee.reps.CarRep;
import hate.hateee.reps.ClientRep;
import hate.hateee.reps.DriverRep;
import hate.hateee.reps.ItemsRep;
import hate.hateee.services.OrderServ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class OrderTest {

    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    @MockBean
    private ItemsRep itemsRep;

    @MockBean
    @Autowired
    private OrderServ orderServ;

    @Autowired
    @MockBean
    private DriverRep driverRep;
    @Autowired
    @MockBean
    private ClientRep clientRep;

    @BeforeEach
    public void setUp() {
        when(orderServ.changeStatus(1L, "waiting to send")).thenReturn(newOrder());
    }


    @Test
    public void changeStatusTest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .put("/orders/{order_id}", 1)
                        .content(mapper.writeValueAsString(new Status("waiting to send")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(newOrder().getId()))
                .andExpect(jsonPath("$.price").value(newOrder().getPrice()))
                .andExpect(jsonPath("$.comments").value(newOrder().getComments()))
                .andExpect(jsonPath("$.firstaddress").value(newOrder().getFirstaddress()))
                .andExpect(jsonPath("$.lastaddress").value(newOrder().getLastaddress()))
                .andExpect(jsonPath("$.status").value(newOrder().getStatus()))
//                .andExpect(jsonPath("$.driver").value(newOrder().getDriver()))
//                .andExpect(jsonPath("$.client").value(newOrder().getClient()))
                .andExpect(jsonPath("$.items[0].id").value(newOrder().getItems().get(0).getId()))
                .andExpect(jsonPath("$.items[0].count").value(newOrder().getItems().get(0).getCount()))
                .andExpect(jsonPath("$.items[0].name").value(newOrder().getItems().get(0).getName()))
                .andExpect(jsonPath("$.items[0].orders").value(newOrder().getItems().get(0).getOrders()))
                .andExpect(jsonPath("$.items[0].price").value(newOrder().getItems().get(0).getPrice()))
                .andExpect(jsonPath("$.orderdate").value(newOrder().getOrderdate()))
                .andDo(document("orders_status", responseFields(
                        fieldWithPath("id").description("Order id"),
                        fieldWithPath("status").description("Order status"),
                        fieldWithPath("price").description("Order price"),
                        fieldWithPath("firstaddress").description("Start address of order"),
                        fieldWithPath("lastaddress").description("End address of order"),
                        fieldWithPath("comments").description("Some comments for order from clients"),
                        fieldWithPath("orderdate").description("Date of order"),
//                        fieldWithPath("client").description("Email and etc."),
//                        fieldWithPath("driver").description("Driver of order"),
                        fieldWithPath("items[0].id").description("Item id in order"),
                        fieldWithPath("items[0].name").description("Name of  each item in order"),
                        fieldWithPath("items[0].price").description("Price of each item in order"),
                        fieldWithPath("items[0].count").description("Count of each item in order"),
                        fieldWithPath("items[0].orders").description("In which order this item (list)")
                )));

    }

    private Order newOrder() {
        return Order.builder()
                .id(1L)
                .price(100)
                .comments("only something")
                .status("on the way")
                .firstaddress("ad1")
                .lastaddress("ad2")
//                .driver(Driver.builder().id(1L).build())
//                .client(Client.builder().id(1L).build())
                .orderdate(Timestamp.valueOf("2020-03-22 02:02:02.000000"))
                .items(list())
                .build();
    }

    private List<Items> list() {
        List<Items> list = new ArrayList<>();
        list.add(Items.builder().id(1L).name("lskdfs").build());
        return list;
//        return itemsRep.getItemsByOrdersOrderById(1L);
    }
}
