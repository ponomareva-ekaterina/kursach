/**
 * Общий класс для работы с запросами списка (пагинация, фильтрация, сортировка).
 */
export class RequestParams{
  paginator: PaginatorRequest = new PaginatorRequest();
  sort: SortRequest;
  filter: FilterRequest;

  /**
   * Метод перевода сущетвующих параметров запроса списка в урл.
   * @returns {string}
   */
  toUrl(): string{
    let urlParams = 'offset=' + this.paginator.offset + '&limit=' + this.paginator.limit;
    if(this.sort != undefined && this.sort != null){
      urlParams += '&sortKey=' + this.sort.sortKey + '&direction=' + this.sort.direction;
    }
    if(this.filter != undefined && this.filter != null && this.filter.search !== ''){
      urlParams += '&searchKey=' + this.filter.filterKey + '&searchName=' + this.filter.search;
    }
    return urlParams;
  }
}

export class PaginatorRequest{
  offset: number;
  limit: number;


  constructor(offset: number = 0, limit: number = 5) {
    this.offset = offset;
    this.limit = limit;
  }
}

export class SortRequest{
  sortKey: string;
  direction: 'asc' | 'desc' | '';


  constructor(sortKey: string, direction) {
    this.sortKey = sortKey;
    this.direction = direction;
  }
}

export class FilterRequest{

  filterKey: string;
  search?: string;


  constructor(filterKey: string, search: string) {
    this.filterKey = filterKey;
    this.search = search;
  }
}

export class SearchParams{
  searchColumnId: number;
  searchPlaceholder: string;


  constructor(searchColumnId: number = 0, searchPlaceholder: string = '') {
    this.searchColumnId = searchColumnId;
    this.searchPlaceholder = searchPlaceholder;
  }
}
