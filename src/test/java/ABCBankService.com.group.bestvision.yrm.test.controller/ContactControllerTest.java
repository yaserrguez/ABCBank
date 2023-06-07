//package ABCBankService.com.group.bestvision.yrm.test.controller;
//
//import ABCBankService.com.group.bestvision.yrm.test.dto.ContactDto;
//import ABCBankService.com.group.bestvision.yrm.test.service.impl.ContactServiceImpl;
//import org.hamcrest.Matchers;
//import org.hamcrest.core.Is;
//import org.junit.jupiter.api.BeforeEach;
//import org.mockito.*;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Collections;
//
//@Transactional
//public class ContactControllerTest
//{
//    private static final String ENDPOINT_URL = "/api/contact";
//    @InjectMocks
//    private ContactController contactController;
//    @Mock
//    private ContactServiceImpl contactService;
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    void setUp()
//    {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(contactController)
//                //.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
//                //.addFilter(CustomFilter::doFilter)
//                .build();
//    }
//
//    @Test
//    public void findAllByPage()
//            throws Exception
//    {
//        Page<ContactDto> page = new PageImpl<>(Collections.singletonList(ContactBuilder.getDto()));
//
//        Mockito.when(contactService.findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(page);
//
//        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL).accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.data.content", Matchers.hasSize(1)));
//
//        Mockito.verify(contactService, Mockito.times(1)).findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any());
//        Mockito.verifyNoMoreInteractions(contactService);
//
//    }
//
//    @Test
//    public void getById()
//            throws Exception
//    {
//        Mockito.when(contactService.findById(ArgumentMatchers.anyLong())).thenReturn(ContactBuilder.getDto());
//
//        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
//        Mockito.verify(contactService, Mockito.times(1)).findById("1");
//        Mockito.verifyNoMoreInteractions(contactService);
//    }
//
//    @Test
//    public void save()
//            throws Exception
//    {
//        Mockito.when(contactService.save(ArgumentMatchers.any(ContactDto.class))).thenReturn(ContactBuilder.getDto());
//
//        mockMvc.perform(MockMvcRequestBuilders.post(ENDPOINT_URL).contentType(MediaType.APPLICATION_JSON).content(CustomUtils.asJsonString(ContactBuilder.getDto()))).andExpect(MockMvcResultMatchers.status().isCreated());
//        Mockito.verify(contactService, Mockito.times(1)).save(ArgumentMatchers.any(ContactDto.class));
//        Mockito.verifyNoMoreInteractions(contactService);
//    }
//
//    @Test
//    public void update()
//            throws Exception
//    {
//        Mockito.when(contactService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(ContactBuilder.getDto());
//
//        mockMvc.perform(MockMvcRequestBuilders.put(ENDPOINT_URL + "/1").contentType(MediaType.APPLICATION_JSON).content(CustomUtils.asJsonString(ContactBuilder.getDto()))).andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(contactService, Mockito.times(1)).update(ArgumentMatchers.any(ContactDto.class), ArgumentMatchers.anyLong());
//        Mockito.verifyNoMoreInteractions(contactService);
//    }
//
//    @Test
//    public void delete()
//            throws Exception
//    {
//        Mockito.doNothing().when(contactService).deleteById(ArgumentMatchers.anyLong());
//        mockMvc.perform(MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1").contentType(MediaType.APPLICATION_JSON).content(CustomUtils.asJsonString(ContactBuilder.getIds()))).andExpect(MockMvcResultMatchers.status().isOk());
//        Mockito.verify(contactService, Mockito.times(1)).deleteById(Mockito.anyLong());
//        Mockito.verifyNoMoreInteractions(contactService);
//    }
//}
